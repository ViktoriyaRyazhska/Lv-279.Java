import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {environment} from "../../../../environments/environment";
import {Group} from "./group.model";

@Injectable()
export class AddGroupService {

  constructor(private http: HttpClient) {}

  getDropdownList(): Observable<any> {
    return this.http.get(environment.serverUrl+'/dropdown',{withCredentials: true});
  }

  getGroupById(groupId: number): Observable<any> {
    return this.http.get(environment.serverUrl+'/group/'+groupId,{withCredentials: true});
  }

  saveGroup(object: any): Observable<any> {
    return this.http.post(environment.serverUrl+'/group/add', object,{withCredentials: true});
  }

  updateGroup(group: Group): Observable<any> {
    return this.http.put(environment.serverUrl+'group/update', group, {withCredentials: true});
  }

}
