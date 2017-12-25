import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {environment} from "../../../../environments/environment";

@Injectable()
export class AddGroupService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get(environment.serverUrl+'/group',{withCredentials: true});
  }

  saveGroup(object: any): Observable<any> {
    return this.http.post(environment.serverUrl+'/group/add', object,{withCredentials: true});
  }
}
