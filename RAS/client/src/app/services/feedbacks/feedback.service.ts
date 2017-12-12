import {EventEmitter, Injectable} from "@angular/core";
import {Student} from "../../models/student";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {of} from "rxjs/observable/of";
@Injectable()
export class FeedbackService {
  private student: Student[];


  constructor(private http: HttpClient){}

  getAllStudent(): Observable<any>  {
    return this.http.get('http://localhost:8080/students/585');

  }

  getStudent(index: number) {
    return this.student[index];
  }
}
