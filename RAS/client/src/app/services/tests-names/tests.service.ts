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

  getAll(groupId:number): Observable<any> {
    return this.http.get('http://localhost:8080/tests/'+groupId);
  }

  addTests(tests: Tests[],groupId:number){
    this.http.post<Tests[]>('http://localhost:8080/tests/add/'+groupId, tests)
      .subscribe(resp => {
          console.log(resp);
        }, err => {
          console.log('Error occured');
        }
      );
  }

}
