import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class AddGroupService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<any> {
    return this.http.get('http://localhost:8080/academy/addgroup');
  }

  post(object: any){
    this.http.post('http://localhost:8080/academy/addgroup', object)
      .subscribe(res => {
        console.log(res);
      }, err => {
        console.log('Error occured');
      }
    );
  }

}
