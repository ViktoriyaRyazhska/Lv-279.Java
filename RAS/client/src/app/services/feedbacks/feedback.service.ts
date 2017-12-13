import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class FeedbackService {
  constructor(private http: HttpClient){}

  getAllStudent(): Observable<any> {
    return this.http.get('http://localhost:8080/students/586');
  }

  updateStudents(students: any){
    this.http.put('http://localhost:8080/students/update', students)
      .subscribe(res => {
          console.log(res);
        }, err => {
          console.log('Error occured');
        }
      );
  }
}
