import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {environment} from "../../../environments/environment";

@Injectable()
export class ReportsService {

  constructor(private http: HttpClient) { }

  getAllForCheckListReport(): Observable<any> {
    return this.http.get<any>(environment.serverUrl+'reports/check_list_by_groups');
  }

}
