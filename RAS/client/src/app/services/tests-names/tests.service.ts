import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Tests} from "../../models/tests";
import {TestsMock} from "./TestsMock";
import {of} from "rxjs/observable/of";


@Injectable()
export class TestsService {

  private testsMock : TestsMock = new TestsMock();
  constructor() {}

  getAllTestNames():Observable<string[]>{
    return of (this.testsMock.tests.testName);
  }
  getAllPoints():Observable<number[]>{
    return of (this.testsMock.tests.max_point);
  }
  getAll():Observable<Tests>{
    return of (this.testsMock.tests);
  }
}
