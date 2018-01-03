import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {FormControl, FormGroup} from "@angular/forms";
import {Group} from "../group/add-group/group.model";

@Injectable()
export class SearchBarService {
  academyStages: any[];
  cityNames: any[];
  direction: any[];
  technology: any[];
  profile: any[];
  paymentStatus = [];

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(environment.serverUrl + '/get-dropdown-list');
  }

}
