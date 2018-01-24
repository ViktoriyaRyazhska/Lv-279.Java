import {Component, Injectable, Input, OnInit} from '@angular/core';
import {StudentsService} from "../../services/students/students.service";
import {UsersService} from "../../services/users/users.service";
import {UserShort} from "../../models/userShort";
import {Data, StudentFeedback, StudentStatus, ApprovedBy, Feedback} from "../../models/feedbacks/student.model";
import {SelectItem} from "primeng/primeng";
import {ActivatedRoute, Router} from "@angular/router";
import {LoginService} from "../auth/login/login.service";
import {Tests} from "../../models/tests";
import {TestsService} from "../../services/tests-names/tests.service";
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
@Injectable()
export class StudentsComponent implements OnInit {
  @Input() groupId: number;
  @Input() techDirect : number;

  private academyId: number;

  private tests: any[];

  private students: StudentFeedback[];

  private employees: ApprovedBy[];

  private selectedStudent: StudentFeedback;

  private displayStudentDetails: boolean;
  private studentStatuses: StudentStatus[];
  private users: UserShort[];

  private selectedUsers: UserShort[];

  private displayUsersList: boolean;
  private displayRemovingDialog: boolean;
  private displayInvalidSavingDialog: boolean;

  private statusesDropdown: SelectItem[] = [];

  private employeesDropdown: SelectItem[] = [];


  constructor(private studentsService: StudentsService,
              private userService: UsersService,
              private route: ActivatedRoute,
              private router: Router,
              private loginService: LoginService,
              private testNamesService: TestsService,
  ) {
    this.selectedStudent = new StudentFeedback();
  }

  ngOnInit() {
    this.academyId = this.groupId;

    this.studentsService.getAll(this.academyId).subscribe(
      data => {
        this.students = data;
        this.students.forEach(st => st.data = st.data == null ? new Data() : st.data);
        this.students.forEach(st => st.teacherFeedback = st.teacherFeedback == null ? new Feedback() : st.teacherFeedback);
        this.students.forEach(st => st.expertFeedback = st.expertFeedback == null ? new Feedback() : st.expertFeedback);

        this.studentsService.getEmployees()
          .subscribe(data => {
              this.employees = data;
              this.employees.forEach(employee =>
                this.employeesDropdown
                  .push({label: employee.fullName, value: employee}))
            }
          );

        this.studentsService.getStatuses()
          .subscribe(data => {
              this.studentStatuses = data;
              this.studentStatuses.forEach(st => this.statusesDropdown.push({label: st.name, value: st}))

            },
            error => console.log(error)
          );

        this.testNamesService.getAll(this.academyId, this.techDirect)
          .subscribe(data => {
              console.log(data);
              this.tests = data;
            },
            error => console.log(error)
          );
      },
      error => {
        if (error.status === 403) {
          this.router.navigate(['ang/error']);
        }
        console.log(error)
      }
    );

    this.userService.getAll(this.academyId)
      .subscribe(
        data => {
          this.users = data;
          console.log(data);
        },
        error => console.log(error)
      )
    console.log(this.employeesDropdown);
  }

  onStudentClick(student: StudentFeedback) {
    this.selectedStudent = student;
    this.displayStudentDetails = true;
  }

  removeDialogStudent(student: StudentFeedback) {
    this.selectedStudent = student;
    this.displayRemovingDialog = true;
  }

  cancelRemovingClick() {
    this.displayRemovingDialog = false;
  }

  updateStudentsClick() {
    if (this.parseTestsMarks()) {
      this.studentsService.update(this.students)
        .subscribe(() => {
            this.students = null;
            this.ngOnInit();
          }
        );
    }

    else {
      this.displayInvalidSavingDialog = true;
    }
  }

  removeSelectedStudent() {
    this.studentsService.remove(this.selectedStudent.id)
      .subscribe(() => {
        this.students = null;
        this.ngOnInit();
      });
    this.displayRemovingDialog = false;
  }

  addUserClick() {
    this.displayUsersList = true;
  }

  cancelAddingClick() {
    this.users = null;
    this.selectedUsers = [];
    this.displayUsersList = false;
  }

  acceptUsersClick() {
    this.studentsService
      .addUsers(this.selectedUsers.map(user => user.id), this.academyId)
      .subscribe(() => {
        this.students = null;
        this.selectedUsers = [];
        this.ngOnInit();
      });

    this.displayUsersList = false;
  }

  private calculate(student: StudentFeedback): number {
    var sum: number = 0;
    var count: number = 0;
    var avg: number;

    if (student.data != null) {
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

  getTrainingScore(student: StudentFeedback): number {
    var sum: number = 0;
    var avg: number = this.calculate(student);

    var count: number = 0;

    if (avg != null) {
      count++;
      sum += avg;
    }

    if (student.data.finalBase != null) {
      sum += student.data.finalBase;
      count++;
    }
    if (student.data.finalLang != null) {
      sum += student.data.finalLang;
      count++;
    }

    if (count != 0) {
      return Math.round((sum / count) * 1000) / 1000;
    }
    else return null;
  }

  getCurrentControl(student: StudentFeedback): number {

    var avg: number = this.calculate(student);

    if (avg != null) {
      return Math.round(avg * 1000) / 1000;
    }
    else return avg;
  }

  mySortCurrentControl(event: any) {
    if (event.order === 1) {
      this.students.sort((a: StudentFeedback, b: StudentFeedback) => {

        const sortDesc = this.getCurrentControl(a) < this.getCurrentControl(b) ? -1 : 0;
        return this.getCurrentControl(a) > this.getCurrentControl(b) ? 1 : sortDesc;

      });
    } else {
      this.students.sort((a: StudentFeedback, b: StudentFeedback) => {

        const sortDesc = this.getCurrentControl(a) < this.getCurrentControl(b) ? 1 : 0;
        return this.getCurrentControl(a) > this.getCurrentControl(b) ? -1 : sortDesc;

      });
    }
    this.students = [...this.students];
  }

  mySortTrainingScore(event: any) {
    if (event.order === 1) {
      this.students.sort((a: StudentFeedback, b: StudentFeedback) => {
        const sortDesc = this.getTrainingScore(a) < this.getTrainingScore(b) ? -1 : 0;
        return this.getTrainingScore(a) > this.getTrainingScore(b) ? 1 : sortDesc;
      });
    } else {
      this.students.sort((a: StudentFeedback, b: StudentFeedback) => {

        const sortDesc = this.getTrainingScore(a) < this.getTrainingScore(b) ? 1 : 0;
        return this.getTrainingScore(a) > this.getTrainingScore(b) ? -1 : sortDesc;

      });
    }
    this.students = [...this.students];
  }

  parseTestsMarks(): boolean {
    for (let k = 0; k < this.students.length; k++) {
      let i = 0;

      if (this.tests[0] != null) {
        i = parseInt(this.students[k].data.testOne + '')
        if (i > this.tests[0].testMaxScore || i < 0) {
          this.students[k].data.testOne = -1;
          return false;
        }
      }

      if (this.tests[1] != null) {
        i = parseInt(this.students[k].data.testTwo + '')
        if (i > this.tests[1].testMaxScore || i < 0) {
          this.students[k].data.testTwo = -1;
          return false;
        }
      }

      if (this.tests[2] != null) {
        i = parseInt(this.students[k].data.testThree + '')
        if (i > this.tests[2].testMaxScore || i < 0) {
          this.students[k].data.testThree = -1;
          return false;
        }
      }

      if (this.tests[3] != null) {
        i = parseInt(this.students[k].data.testFour + '')
        if (i > this.tests[3].testMaxScore || i < 0) {
          this.students[k].data.testFour = -1;
          return false;
        }
      }

      if (this.tests[4] != null) {
        i = parseInt(this.students[k].data.testFive + '')
        if (i > this.tests[4].testMaxScore || i < 0) {
          this.students[k].data.testFive = -1;
          return false;
        }
      }

      if (this.tests[5] != null) {
        i = parseInt(this.students[k].data.testSix + '')
        if (i > this.tests[5].testMaxScore || i < 0) {
          this.students[k].data.testSix = -1;
          return false;
        }
      }

      if (this.tests[6] != null) {
        i = parseInt(this.students[k].data.testSeven + '')
        if (i > this.tests[6].testMaxScore || i < 0) {
          this.students[k].data.testSeven = -1;
          return false;
        }
      }

      if (this.tests[7] != null) {
        i = parseInt(this.students[k].data.testEight + '')
        if (i > this.tests[7].testMaxScore || i < 0) {
          this.students[k].data.testEight = -1;
          return false;
        }
      }

      if (this.tests[8] != null) {
        i = parseInt(this.students[k].data.testNine + '')
        if (i > this.tests[8].testMaxScore || i < 0) {
          this.students[k].data.testNine = -1;
          return false;
        }
      }

      if (this.tests[9] != null) {
        i = parseInt(this.students[k].data.testTen + '')
        if (i > this.tests[9].testMaxScore || i < 0) {
          this.students[k].data.testTen = -1;
          return false;
        }
      }
    }
    return true;
  }

  setTests (tests : any[]) {
    this.tests = [];
    tests.forEach(test=>{
      if(test.value.removed) {
        let i = tests.indexOf(test);
        tests.splice(i, 1);
      }
    });

    this.tests = tests;
  }
}
