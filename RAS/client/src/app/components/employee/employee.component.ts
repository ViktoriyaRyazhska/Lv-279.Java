import {Component, Input, OnInit} from '@angular/core';
import {Employee} from "./Employee";
import {EmployeeService} from "./employee.service";
import {GroupInfoTeachers} from "./GroupInfoTeachers";
import {Authority} from "../auth/Authority";
import {LoginService} from "../auth/login/login.service";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  @Input() groupId: number;
  private displayUsersList: boolean;
  private employeesTeacher: Employee[];
  private employeesExpert: Employee[];
  private employeesInterviewer: Employee[];
  private selectedEmployee: Employee[];
  private acceptedEmployees = [];
  private groupInfoTeachers: GroupInfoTeachers[];


  constructor(private employeeService: EmployeeService,
              private loginService: LoginService) {
  }

  ngOnInit() {
    this.employeeService.getGroupInfoTeachers(this.groupId).subscribe(data => {
      this.groupInfoTeachers = data;
    });

    this.employeeService.findAllExperts().subscribe(data => {
      this.employeesTeacher = data;
      this.employeesTeacher.forEach(somedata => {
        somedata.teacherType = Authority.TEACHER;

      });
    });
    this.employeeService.findAllExperts().subscribe(data => {
      this.employeesExpert = data;
      this.employeesExpert.forEach(somedata => {
        somedata.teacherType = Authority.EXPERT;
      });
    });
    this.employeeService.findAllExperts().subscribe(data => {
      this.employeesInterviewer = data;
      this.employeesInterviewer.forEach(somedata => {
        somedata.teacherType = Authority.INTERVIEWER;
      });
    });
  }

  addEmployeeClick() {
    this.displayUsersList = true;
    this.selectedEmployee = [];
  }

  cancelAddingClick() {
    this.selectedEmployee = [];
    this.displayUsersList = false;
  }

  acceptEmployeesClick() {
    this.employeeService.assignEmployee(this.convertToArrayOfGroupInfoTeachers(this.selectedEmployee)).subscribe(data => {
      this.ngOnInit();
      this.selectedEmployee = [];
      this.displayUsersList = false;
    });
  }

  convertToArrayOfGroupInfoTeachers(selectedEmployee: Employee[]): GroupInfoTeachers[] {
    for (let i = 0; i < selectedEmployee.length; i++) {
      this.acceptedEmployees[i] = new GroupInfoTeachers();
      this.acceptedEmployees[i].employee = this.selectedEmployee[i].employeeId;
      this.acceptedEmployees[i].academy = this.groupId;
      this.acceptedEmployees[i].teacherType = this.selectedEmployee[i].teacherType;
    }
    return this.acceptedEmployees;
  }

  updateEmployee() {
    this.employeeService.update(this.parsecontributedHours(this.groupInfoTeachers)).subscribe(() => {
        this.groupInfoTeachers = [];
        this.employeeService.getGroupInfoTeachers(this.groupId).subscribe(data => {
          this.groupInfoTeachers = data;
        });
      }, error2 => console.log(error2),
      () => console.log('groupInfoTeachers was updated'))
  }

  parsecontributedHours(groupInfoTeachers: GroupInfoTeachers[]): GroupInfoTeachers[] {
    this.groupInfoTeachers.forEach(data => {
      data.contributedHours = parseInt(data.contributedHours + '');
      if (data.contributedHours < 0) {
        data.contributedHours = 0;
      }
    });
    return this.groupInfoTeachers;
  }

  removeEmployee(group: GroupInfoTeachers) {
    this.employeeService.remove(group.id).subscribe(() => {

      }, error2 => console.log(error2),
      () => {
        this.employeeService.getGroupInfoTeachers(this.groupId).subscribe(data => {
          this.groupInfoTeachers = data;
        });
      });
    this.selectedEmployee = [];
  }
}
