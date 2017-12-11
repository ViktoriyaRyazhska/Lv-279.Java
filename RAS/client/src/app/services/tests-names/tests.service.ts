import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Tests} from "../../models/tests";
import {TestsMock} from "./TestsMock";
import {of} from "rxjs/observable/of";
import {HttpClient} from '@angular/common/http';


@Injectable()
export class TestsService {

  private testsMock : TestsMock = new TestsMock();
  constructor(private http: HttpClient) {}

  // getAllTestNames():Observable<string[]>{
  //   return of (this.testsMock.tests.testName);
  // }
  // getAllPoints():Observable<number[]>{
  //   return of (this.testsMock.tests.max_point);
  // }
  // getAll():Observable<Tests>{
  //   return of (this.testsMock.tests);
  // }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:8080/tests/585');
  }
}
