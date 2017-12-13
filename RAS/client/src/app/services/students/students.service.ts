import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/of';
import {StudentFeedback} from "../../models/feedbacks/student.model";
import {environment} from "../../../environments/environment";


@Injectable()
export class StudentsService {

  constructor(private http: HttpClient) {
  }

  getAll(academyId: number): Observable<any> {
    let url = environment.serverUrl + 'students/' + academyId;
    return this.http.get(url);
  }

  getStatuses(): Observable<any> {
    let url = environment.serverUrl + 'students/statuses';
    return this.http.get(url);
  }

  addUsers(object: number[], academyId: number): Observable<any> {
    let url = environment.serverUrl + 'students/' + academyId + '/add';
    return this.http.post(url, object);
  }

  remove(studentId: number): Observable<any> {
    let url = environment.serverUrl + 'students/' + studentId;
    return this.http.delete(url);
  }

  update(students: StudentFeedback[]): Observable<any> {
    let url = environment.serverUrl + 'students/update';
    console.log(students);
    return this.http.put(url, students);
  }

}
