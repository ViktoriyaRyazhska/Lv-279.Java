import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Tests} from "../../models/tests";
import {HttpClient} from '@angular/common/http';
import {environment} from "../../../environments/environment";


@Injectable()
export class TestsService {

  constructor(private http: HttpClient) {}

  getAll(groupId:number,techDirect:number): Observable<any> {
    return this.http.get(environment.serverUrl + 'tests/' + groupId + '/' + techDirect);
  }

  getTestTemplates(techDirect:number): Observable<any> {
    return this.http.get(environment.serverUrl + '/tests/template/' + techDirect);
  }

  getResponse(groupId:number): Observable<any> {
    return this.http.get(environment.serverUrl + 'tests/add/' + groupId);
  }

  addTests(tests: Tests[],groupId:number) : Observable<any> {
    return this.http.post<Tests[]>(environment.serverUrl + 'tests/add/' + groupId, tests);
  }
}
