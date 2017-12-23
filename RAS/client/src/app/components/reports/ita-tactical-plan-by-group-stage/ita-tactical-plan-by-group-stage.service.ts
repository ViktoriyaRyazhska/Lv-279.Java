import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {environment} from "../../../../environments/environment";

@Injectable()
export class ItaTacticalPlanByGroupStageService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(environment.serverUrl+'reports/ita_tactical_report');
  }

}

