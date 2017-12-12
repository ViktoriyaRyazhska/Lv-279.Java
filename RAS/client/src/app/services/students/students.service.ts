import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/of';
import {StudentStatus} from "../../models/feedbacks/student.model";

@Injectable()
export class StudentsService{

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:8080/students/585');
  }

  getStatuses():Observable<any>{
    return this.http.get('http://localhost:8080/students/statuses');
  }

  addUsers(object: number[]):Observable<any>{
    return this.http.post('http://localhost:8080/students/585/add', object);
  }

  remove(studentId: number): Observable<any> {
    let q = "http://localhost:8080/students/"+studentId;
    return this.http.delete(q);
  }
}
