import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/of';

@Injectable()
export class StudentsService{

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:8080/students/585');
  }

  addUsers(object: number[]):Observable<Object>{
    return this.http.post('http://localhost:8080/students/585/add', object);
  }
}
