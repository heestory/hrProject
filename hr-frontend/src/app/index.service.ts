import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import {Index } from './index';
import {Submit} from './submit';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class IndexService {
	
	private indexUrl = "api/index";
	private createUrl = "api/create";
	private headers = new Headers({'Content-Type':'application/json'});
	

	constructor(private http: Http) { }
	
	getIndexData(): Promise<Index[]>{
		return this.http.get(this.indexUrl)
				   .toPromise()
				   .then(response => response.json() as Index[])
				   .catch(this.handleError);
	}
	
	createIndexData(submit : Submit):Promise<Index[]>{
		debugger;
		return this.http
			.post(this.createUrl, JSON.stringify(submit),{headers: this.headers})
			.toPromise()
			.then(res => res.json() as Index[])
			.catch(this.handleError);
	}
	
	private handleError(error: any): Promise<any> {
	    console.error('Error', error); // for demo purposes only
	    return Promise.reject(error.message || error);
	 }

}
