import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

import {StudentFeedback} from "../../models/feedbacks/student.model";

@Injectable()
export class FeedbackService {
  private students: Array<StudentFeedback>;

  constructor(private http: HttpClient){}

  getAllStudent(): Observable<any> {
    return this.http.get('http://localhost:8080/students/585');
  }
}
