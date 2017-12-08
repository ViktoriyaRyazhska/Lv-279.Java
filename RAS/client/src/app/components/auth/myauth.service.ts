import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class MyauthService{
  private SERVER_ADDRESS: 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  get(url: string): Observable<any> {
    return this.http.get(url, {withCredentials: true});
  }
  post(url: string, body: any) {
    return this.http.post(url, body, {withCredentials: true});
  }

}
