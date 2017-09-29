import { Component, OnInit } from '@angular/core';
import {Index } from '../index';
import { Submit } from '../submit';
import {IndexService} from '../index.service';

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

	
	submitValue = new Submit;
	
    constructor(private indexService : IndexService) { }
    
    ngOnInit(): void {
 	   this.getIndexDatas();
     }
    
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
    
    
    private save(){
    	return this.indexService.createIndexData(this.submitValue).then(submitResultData => this.indexData = submitResultData);
    }
    
    
    onSubmit(){
    	this.submitValue.submitList = this.siteList.join();
    	this.submitted = true;
    	this.save();
    }
    
    
}
