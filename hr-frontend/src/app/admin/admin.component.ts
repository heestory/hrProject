import { Component, OnInit } from '@angular/core';
import {IndexService} from '../index.service';
import { Image } from '../image';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

	images : Image[];
	
  constructor(private indexService: IndexService) {
  }
  
  ngOnInit() {
	  debugger;
	  this.indexService.getImageData().then(images => this.images = images);
  }

}
