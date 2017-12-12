import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class UsersService {

  constructor(private http: HttpClient) { }

  page(num: number, size: number, dir: string, notInAcademy: number, idFilter: string): Observable<any> {
    let q = 'http://localhost:8080/user?' +
      `page=${num}&size=${size}&dir=${dir}&notInAcademy=${notInAcademy}`;
    if (idFilter != null) {
      q += `&id=${idFilter}`;
    }
    return this.http.get(q);
  }
}
