import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Tests} from "../../models/tests";
import {TestsMock} from "./TestsMock";
import {of} from "rxjs/observable/of";
import {HttpClient} from '@angular/common/http';
import {environment} from "../../../environments/environment";


@Injectable()
export class TestsService {

  private testsMock : TestsMock = new TestsMock();
  constructor(private http: HttpClient) {}

  getAll(groupId:number): Observable<any> {
    return this.http.get(environment.serverUrl + 'tests/' + groupId);
  }

  getResponse(groupId:number): Observable<any> {
    return this.http.get(environment.serverUrl + 'tests/add/' + groupId);
  }

  addTests(tests: Tests[],groupId:number){
    this.http.post<Tests[]>(environment.serverUrl + 'tests/add/' + groupId, tests)
      .subscribe(resp => {
          console.log(resp);
        }, err => {
          console.log('Error occured');
        }
      );
  }

}
