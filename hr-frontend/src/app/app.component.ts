import { Component, OnInit } from '@angular/core';
import { Customer } from './customer';
import {HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {IndexService} from './index.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
	
	imageUrl : string = '/assets/images/header.jpg';

	constructor(private indexService : IndexService){
		
	}

	delete(){
		
		this.indexService.deleteData();
		
	}
	

}
