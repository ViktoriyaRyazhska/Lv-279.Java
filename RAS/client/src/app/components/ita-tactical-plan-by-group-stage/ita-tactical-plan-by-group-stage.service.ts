import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ItaTacticalPlanByGroupStageService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    console.log(this.http.get('http://localhost:8080/itaTacticalPlanByGroupStage'));
    return this.http.get('http://localhost:8080/itaTacticalPlanByGroupStage');
  }

}
