import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {environment} from "../../../environments/environment";


@Injectable()
export class MarkService {
  constructor(private http: HttpClient) {
  }

  getAllMarks(): Observable<any> {
    let url = environment.serverUrl + 'marks';
    return this.http.get(url,{withCredentials: true});
  }
}
