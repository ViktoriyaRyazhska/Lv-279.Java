import {EventEmitter} from "@angular/core";
import {Student} from "../../models/student";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {StudentsMockupRepo} from "../students/studentsMockupRepo";
import {of} from "rxjs/observable/of";

export class FeedbackService {
  private student: Student[];
  // private studentsMock: StudentsMockupRepo = new StudentsMockupRepo();

  constructor(private http: HttpClient){}

  getAllStudent(): Observable<any>  {
    return this.http.get('http://localhost:8080/students/585');
    // return of(this.studentsMock.students);
  }

  getStudent(index: number) {
    return this.student[index];
  }
}
