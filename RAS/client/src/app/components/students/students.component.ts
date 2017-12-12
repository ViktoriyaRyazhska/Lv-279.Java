import {Component, OnInit} from '@angular/core';
import {StudentsService} from "../../services/students/students.service";
import {Student} from "../../models/student";
import {UsersService} from "../../services/users/users.service";
import {UserPage, UserShort} from "../../models/userShort";


@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
  private students: Student[];
  private selectedStudent: Student;

  private displayStudentDetails: boolean;


  private users: UserPage = new UserPage();
  private selectedUsers: UserShort[];
  private displayUsersList: boolean;

  constructor(private studentsService: StudentsService, private userService: UsersService) {
    this.selectedStudent = new Student();
  }

  ngOnInit() {
    this.studentsService.getAll().subscribe(
      data => {
        this.students = data;
        console.log("loaded " + data.length);
      },
      error => console.log(error)
    );
  }


  onStudentClick(student: Student) {
    this.selectedStudent = student;
    this.displayStudentDetails = true;
  }

  removeStudent(student: Student) {
    this.selectedStudent = student;
    this.studentsService
      .remove(585, this.selectedStudent.id)
      .subscribe(() => {
        this.students = null;
        this.ngOnInit();
      });
  }

  addUserClick() {
    this.loadUsers({first: 0, rows: 15});
    this.displayUsersList = true;
  }

  cancelAddingClick() {
    this.users = null;
    this.selectedUsers = [];
    this.displayUsersList = false;
  }

  acceptUsersClick() {
    this.studentsService
      .addUsers(this.selectedUsers.map(user => user.id))
      .subscribe(() => {
        this.students = null;
        this.selectedUsers = [];
        this.ngOnInit();
      });

    this.displayUsersList = false;
  }

  loadUsers(event) {
    console.log(event);

    if (event.first != null && event.rows != null) {

      let pageNum = event.first / event.rows;
      let dir = event.sortOrder == -1 ? 'desc' : 'asc';

      let idFilter = null;
      if (event.filters != null && event.filters.id != null) {
        idFilter = event.filters.id.value;
      }

      this.userService.page(pageNum, event.rows, dir, 585, idFilter).subscribe(
        data => {
          this.users = data;

        },
        error => console.log(error)
      );

    }
  }

}
