import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {environment} from "../../../environments/environment";

@Injectable()
export class UsersService {

  constructor(private http: HttpClient) { }

  getAll(academyId:number): Observable<any> {
    let url = environment.serverUrl+'users/'+academyId;
    return this.http.get(url,{withCredentials: true});
  }
}
