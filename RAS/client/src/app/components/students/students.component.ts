import {Component, OnInit} from '@angular/core';
import {StudentsService} from "../../services/students/students.service";
import {Student} from "../../models/student";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
  private students:Student[];
  private selectedStudent:Student;
  constructor(private studentsService: StudentsService) {
  }

  ngOnInit() {
    this.studentsService.getAll().subscribe(
      data => {
        this.students = data;
      },
      error => console.log(error)
    );
  }
  onStudentClick(student:Student){
    this.selectedStudent = student;
  }

}
