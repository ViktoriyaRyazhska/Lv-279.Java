import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {environment} from "../../../../environments/environment";

@Injectable()
export class GroupOverviewService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(environment.serverUrl + '/get-group-overview-dropdown');
  }

  showReport(groupId: number): Observable<any> {
    return this.http.get(environment.serverUrl + 'students/get-group-overview-report/' + groupId, {withCredentials: true});
  }
}
