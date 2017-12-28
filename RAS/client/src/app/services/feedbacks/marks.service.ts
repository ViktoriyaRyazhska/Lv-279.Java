import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {environment} from "../../../environments/environment";
import {Mark} from "../../models/feedbacks/mark.model";

@Injectable()
export class MarkService {
  private marks: Mark[];

  constructor(private http: HttpClient) {

  }

  getAllMarks(): Observable<any> {
    let url = environment.serverUrl + 'marks';
    return this.http.get(url,{withCredentials: true});
  }
}
