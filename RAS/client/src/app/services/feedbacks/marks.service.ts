import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {environment} from "../../../environments/environment";
import {Mark} from "../../models/feedbacks/mark.model";

export enum CharacteristicId {
  ONE = 1,
  TWO = 2,
  THREE = 3,
  FOUR = 4,
  FIVE = 5,
  SIX = 6
}

@Injectable()
export class MarkService {
  private marks: Mark[];

  constructor(private http: HttpClient) {

  }

  getAllMarks(): Observable<any> {
    let url = environment.serverUrl + 'marks';
    return this.http.get(url,{withCredentials: true});
  }
}
