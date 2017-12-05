
import { Injectable } from '@angular/core';
import {BaseService} from "../base.service";
import {HttpClient} from "@angular/common/http";
import {StudentsMockupRepo} from "./studentsMockupRepo";
import {Student} from "../../models/student";
import {Observable} from "rxjs/Observable";
import {of} from "rxjs/observable/of";


@Injectable()
export class StudentsService extends BaseService{

  private studentsMock: StudentsMockupRepo = new StudentsMockupRepo();

  constructor(client: HttpClient) {
    super(client)
    this.parPath="students"
  }

  getAll():Observable<Student[]>{
    return of(this.studentsMock.students);
  }

}
