import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {ChListGr} from "./check-list-by-groups/ChListGr";

@Injectable()
export class ReportsService {

  constructor(private http: HttpClient) { }

  getAllForCheckListReport(): Observable<ChListGr> {
    return this.http.get<ChListGr>('http://localhost:8080/reports/check_list_by_groups');
  }

}
