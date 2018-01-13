import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {environment} from "../../../environments/environment";
import {Feedback} from "../../models/feedbacks/student.model";


@Injectable()
export class FeedbackService {

  constructor(private http: HttpClient) {}

  updateFeedback(feedback: Feedback): Observable<any> {
    let url = environment.serverUrl+'feedback/update';
    return this.http.put(url,feedback, {withCredentials: true});
  }

  updateInterviewerComment(interviewerComment: string, studentId: number): Observable<any> {
    let url = environment.serverUrl + 'feedback/update_comment/'+ studentId;
    return this.http.put(url, interviewerComment,  {withCredentials: true});
  }
}
