import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {StudentFeedback} from "../../models/feedbacks/student.model";
import {environment} from "../../../environments/environment";
import 'rxjs/add/observable/of';


@Injectable()
export class StudentsService{

  constructor(private http: HttpClient) { }

  getAll(academyId:number): Observable<any> {
    let url = environment.serverUrl+'students/'+academyId;
    return this.http.get(url,{withCredentials: true});
  }

  update(students: StudentFeedback[]): Observable<any> {
    let url = environment.serverUrl+'students/update';
    return this.http.put(url,students, {withCredentials: true});
  }

  updateStudent(student: StudentFeedback): Observable<any> {
    let url = environment.serverUrl+'students/update_student';
    return this.http.put(url,student, {withCredentials: true});
  }

  remove(studentId: number): Observable<any> {
    let url = environment.serverUrl+'students/'+studentId;
    return this.http.delete(url, {withCredentials: true});
  }

  addUsers(object: number[], academyId:number):Observable<any>{
    let url = environment.serverUrl+'students/'+academyId+'/add';
    return this.http.post(url, object, {withCredentials: true});
  }

  getStatuses():Observable<any>{
    let url = environment.serverUrl+'students/statuses';
    return this.http.get(url,{withCredentials: true});
  }

  getEmployees():Observable<any>{
    let url = environment.serverUrl+'students/employee';
    return this.http.get(url, {withCredentials: true});
  }
}
