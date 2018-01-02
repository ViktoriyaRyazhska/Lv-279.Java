import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../environments/environment";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ItaTacticalReportService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(environment.serverUrl+'reports/ita_tactical_report');
  }

}
