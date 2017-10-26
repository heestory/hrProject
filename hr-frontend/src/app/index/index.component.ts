import { Component, OnInit } from '@angular/core';
import {Index } from '../index';
import { Submit } from '../submit';
import {IndexService} from '../index.service';
import {UploadService} from '../upload.service';

const URL = "/api2/create";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
	
	indexData : Index[];
	siteList : number[] = [];
    checkValue : boolean = false; 
	submitted : boolean = false;
	selectedFiles : FileList;
	currentFileUpload : File;

	private isSpinnerActive : boolean;
	
	submitValue = new Submit;
	
    constructor(private indexService : IndexService, private uploadService: UploadService) { }
    
    ngOnInit(): void {
 	   this.getIndexDatas();
     }
    
    //이미지 업로드 파일 생성
    selectFile(event){
    	const file = event.target.files.item(0);
    	debugger
    	if(file.type.match('image.*')){
    		this.selectedFiles = event.target.files;
    		
    		//업로드 파일을 먼저 서버로 전송한다.
        	this.upload();
    	}else{
    		alert('invalid fomat');
    	}
    	
    }
    //이미지 업로드 등록
    upload(){
    	this.currentFileUpload = this.selectedFiles.item(0);
    	this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
    		console.log('File is completely uploaded');
    	})
    	
    	this.selectedFiles = undefined;
    }
    
    //초기 사이트 정보 가져옴
    getIndexDatas(){
	   return this.indexService.getIndexData().then(indexData => this.indexData = indexData);
    }
    
    //체크박스 체크시 값 저장
    addList(element : HTMLInputElement): void{
    	if(element.checked){
    		this.siteList.push(Number(element.value));
    	}else{
    		this.siteList.shift();
    	}
    }
    
    //값 등록
    private save(){
    	return this.indexService.createIndexData(this.submitValue).then(
    			function(submitResultData){
    				this.indexData = submitResultData;
    				this.isSpinnerActive = false;
    				return this.indexData;
    				}
    			);
    }
    
    onSubmit(event){
    	this.submitValue.submitList = this.siteList.join();
    	this.submitted = true;
    	this.isSpinnerActive = true;
    	this.save();
    }
    
    //로딩바 생성
    
    
    
}
