import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {environment} from "../../../../environments/environment";

@Injectable()
export class AddGroupService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get(environment.serverUrl+'academy/addgroup');
  }

  post(object: any){
    this.http.post(environment.serverUrl+'academy/addgroup', object)
      .subscribe(res => {
        console.log(res);
      }, err => {
        console.log('Error occured');
      }
    );
  }

}
