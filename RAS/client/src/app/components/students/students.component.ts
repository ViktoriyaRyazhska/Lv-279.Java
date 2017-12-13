import {Component, OnInit} from '@angular/core';
import {StudentsService} from "../../services/students/students.service";
import {UsersService} from "../../services/users/users.service";
import {UserPage, UserShort} from "../../models/userShort";
import {Data, StudentFeedback, StudentStatus} from "../../models/feedbacks/student.model";
import {SelectItem} from "primeng/primeng";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
  private academyId: number = 586;

  private students: StudentFeedback[];

  private selectedStudent: StudentFeedback;

  private displayStudentDetails: boolean;
  private studentStatuses: StudentStatus[];

  private users: UserPage = new UserPage();
  private selectedUsers: UserShort[];
  private displayUsersList: boolean;

  private displayRemovingDialog: boolean;

  private statuses: SelectItem[] = [];

  constructor(private studentsService: StudentsService, private userService: UsersService) {
    this.selectedStudent = new StudentFeedback();
  }

  ngOnInit() {
    this.studentsService.getAll(this.academyId).subscribe(
      data => {
        this.students = data;
        this.students.forEach(st => st.data = st.data == null ? new Data() : st.data);
        console.log("loaded " + data.length);
        this.studentsService.getStatuses().subscribe(data => {
            this.studentStatuses = data;
            this.studentStatuses.forEach(st => this.statuses.push({label: st.name, value: st}))
            console.log(this.statuses);
          },
          error => console.log(error)
        );
      },
      error => console.log(error)
    );
    this.loadUsers({first: 0, rows: 15});

  }


  onStudentClick(student: StudentFeedback) {
    this.selectedStudent = student;
    this.displayStudentDetails = true;
  }

  removeDialogStudent(student: StudentFeedback){
    this.selectedStudent = student;
    this.displayRemovingDialog = true;

  }

  cancelRemovingClick() {
    this.displayRemovingDialog =  false;
  }

  removeSelectedStudent() {
    this.studentsService
      .remove(this.selectedStudent.id)
      .subscribe(() => {
        // var index = this.students.indexOf(this.selectedStudent, 0);
        // if (index > -1) {
        //   this.students.splice(index, 1);
        // }


        this.students = null;
        this.ngOnInit();
      });
    this.displayRemovingDialog =  false;
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
      .addUsers(this.selectedUsers.map(user => user.id),this.academyId)
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

      this.userService.page(pageNum, event.rows, dir, this.academyId, idFilter).subscribe(
        data => {
          this.users = data;

        },
        error => console.log(error)
      );

    }
  }

  updateStudentsClick(){
    this.studentsService.update(this.students).subscribe(()=>{
      this.students = null;
      this.ngOnInit();
      }
    );
  }


}
