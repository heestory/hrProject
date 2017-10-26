import { Injectable } from '@angular/core';
import {HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class UploadService {

  constructor(private http: HttpClient) { }
  
  pushFileToStorage(file: File) : Observable<HttpEvent<{}>>{
	  	let formdata: FormData = new FormData();
  
  		formdata.append('file',file);
  		
  		const req = new HttpRequest('POST','/api2/upload',formdata,{
  			reportProgress: true,
  			responseType:'text'
  		});
  		
  		return this.http.request(req);
  }
}
