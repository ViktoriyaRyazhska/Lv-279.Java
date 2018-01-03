import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {environment} from "../../../environments/environment";
import {GroupInfoTeachers} from "./GroupInfoTeachers";
import {Employee} from "./Employee";

@Injectable()
export class EmployeeService {

  constructor(private http: HttpClient) { }

  findAllExperts():Observable<any>{
    let url=environment.serverUrl+'employee/experts';
    return this.http.get(url, {withCredentials: true});
  }

  assignEmployee(object: GroupInfoTeachers []){
    let url = environment.serverUrl+'employee/assign';
    return this.http.post(url, object, {withCredentials: true});
  }

  getGroupInfoTeachers(academyid:number):Observable<any>{
    let url=environment.serverUrl+'employee/group/'+academyid;
    return this.http.get(url, {withCredentials: true});
  }

  update(groupInfoTeachers: GroupInfoTeachers []): Observable<any> {
    let url = environment.serverUrl+'employee/update';
    return this.http.put(url, groupInfoTeachers, {withCredentials: true});
  }
}
