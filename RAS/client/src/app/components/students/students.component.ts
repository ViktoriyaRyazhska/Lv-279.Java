import {Component, OnInit} from '@angular/core';
import {StudentsService} from "../../services/students/students.service";
import {UsersService} from "../../services/users/users.service";
import {UserPage, UserShort} from "../../models/userShort";
import {Data, StudentFeedback, StudentStatus, ApprovedBy} from "../../models/feedbacks/student.model";
import {SelectItem} from "primeng/primeng";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
  private academyId: number = 586;

  private students: StudentFeedback[];

  private employees: ApprovedBy[];

  private selectedStudent: StudentFeedback;

  private displayStudentDetails: boolean;
  private studentStatuses: StudentStatus[];

  private users: UserPage = new UserPage();
  private selectedUsers: UserShort[];
  private displayUsersList: boolean;

  private displayRemovingDialog: boolean;

  private statusesDropdown: SelectItem[] = [];

  private employeesDropdown: SelectItem[] = [];



  constructor(private studentsService: StudentsService, private userService: UsersService) {
    this.selectedStudent = new StudentFeedback();
  }

  ngOnInit() {
    this.studentsService.getAll(this.academyId).subscribe(
      data => {
        this.students = data;
        this.students.forEach(st => st.data = st.data == null ? new Data() : st.data);
        this.studentsService.getEmployees().subscribe(data=> {
            this.employees = data;
            this.employees.forEach(employee=>
              this.employeesDropdown
                .push(
                  {label: employee.fullName,
                    value: employee}))
          }
        );

        this.studentsService.getStatuses().subscribe(data => {
            this.studentStatuses = data;
            this.studentStatuses.forEach(st => this.statusesDropdown.push({label: st.name, value: st}))

          },
          error => console.log(error)
        );
      },
      error => console.log(error)
    );
    this.loadUsers({first: 0, rows: 15});

    console.log(this.employeesDropdown);
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

  private  calculate(student:StudentFeedback):number{
    var sum:number = 0;
    var count: number = 0;
    var avg :number;

    if(student.data!= null) {
      if (student.data.testOne != null) {
        sum += student.data.testOne;
        count++;
      }
      if (student.data.testOne != null) {
        sum += student.data.testTwo;
        count++;
      }
      if (student.data.testThree != null) {
        sum += student.data.testThree;
        count++;
      }
      if (student.data.testFour != null) {
        sum += student.data.testFour;
        count++;
      }
      if (student.data.testFive != null) {
        sum += student.data.testFive;
        count++;
      }
      if (student.data.testSix != null) {
        sum += student.data.testSix;
        count++;
      }
      if (student.data.testSeven != null) {
        sum += student.data.testSeven;
        count++;
      }
      if (student.data.testEight != null) {
        sum += student.data.testEight;
        count++;
      }
      if (student.data.testNine != null) {
        sum += student.data.testNine;
        count++;
      }
      if (student.data.testTen != null) {
        sum += student.data.testTen;
        count++;
      }
    }

    if (count) {
      return avg = sum / count;
    } else {
      return avg;
    }
  }

  getTrainingScore(student:StudentFeedback):number{
    var sum: number;
    var avg :number =  this.calculate(student);

    sum+=avg;

    var count :number = 0;

    if (avg != null){
      count++;
    }

    if (student.data.finalBase!=null){
      sum+=student.data.finalBase;
      count++;
    }
    if (student.data.finalLang!=null){
      sum+=student.data.finalLang;
      count++;
    }

    if(count!=0) {
      return Math.round((sum/count) * 1000) / 1000;
    }
    else return avg;
  }
   getCurrentControl(student:StudentFeedback) :number{

      var avg:number = this.calculate(student);

        if(avg!=null) {
        return Math.round(avg * 1000) / 1000;
      }
      else return avg;

  }

  updateStudentsClick(){
    this.studentsService.update(this.students).subscribe(()=>{
      this.students = null;
      this.ngOnInit();
      }
    );
  }


}
