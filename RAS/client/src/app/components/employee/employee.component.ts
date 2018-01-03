import {Component, Input, OnInit} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {EmployeeAddComponent} from "./employee-add/employee-add.component";
import {Employee} from "./Employee";
import {EmployeeService} from "./employee.service";
import {GroupInfoTeachers} from "./GroupInfoTeachers";
import {forEach} from "@angular/router/src/utils/collection";
import {Authority} from "../auth/Authority";

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
  private selectedTeacher:boolean;
  private selectedExpert:boolean;
  private selectedInterviewer:boolean;


  constructor(private employeeService:EmployeeService) {}

  ngOnInit() {
    this.selectedTeacher=true;
    this.selectedExpert=false;
    this.selectedInterviewer=false;
    this.employeeService.getGroupInfoTeachers(this.groupId).subscribe(data=>{
      this.groupInfoTeachers=data;
    });

    this.employeeService.findAllExperts().subscribe(data=>{
      this.employeesTeacher=data;
      this.employeesTeacher.forEach(somedata=>{
        somedata.teacherType=Authority.TEACHER;
      });
    });
    this.employeeService.findAllExperts().subscribe(data=>{
      this.employeesExpert=data;
      this.employeesExpert.forEach(somedata=>{
        somedata.teacherType=Authority.EXPERT;
      });
    });
    this.employeeService.findAllExperts().subscribe(data=>{
      this.employeesInterviewer=data;
      this.employeesInterviewer.forEach(somedata=>{
        somedata.teacherType=Authority.INTERVIEWER;
      });
    });
  }

  addEmployeeClick() {
    this.displayUsersList = true;
  }

  cancelAddingClick() {
    this.selectedEmployee = [];
    this.displayUsersList = false;
  }

  acceptEmployeesClick() {
    this.employeeService.assignEmployee(this.convertToArrayOfGroupInfoTeachers(this.selectedEmployee)).subscribe(data=>{
      this.selectedEmployee = [];
      this.displayUsersList = false;
      this.employeeService.getGroupInfoTeachers(this.groupId).subscribe(data=>{
        this.groupInfoTeachers=data;
      });
    });
  }

  convertToArrayOfGroupInfoTeachers(selectedEmployee: Employee[]): GroupInfoTeachers[]{
   for (let i=0;i<selectedEmployee.length;i++){
     this.acceptedEmployees[i]=new GroupInfoTeachers();
     this.acceptedEmployees[i].employee = this.selectedEmployee[i].employeeId;
     this.acceptedEmployees[i].academy=this.groupId;
     this.acceptedEmployees[i].teacherType=this.selectedEmployee[i].teacherType;
   }
    return this.acceptedEmployees;
  }

  updateEmployee(){
    this.employeeService.update(this.parsecontributedHours(this.groupInfoTeachers)).subscribe(()=>{
        this.groupInfoTeachers=[];
        this.employeeService.getGroupInfoTeachers(this.groupId).subscribe(data=>{
          this.groupInfoTeachers=data;
        });
    },error2 => console.log(error2),
      () => console.log('groupInfoTeachers was updated'))
  }

  parsecontributedHours(groupInfoTeachers: GroupInfoTeachers[]):GroupInfoTeachers[]{
    this.groupInfoTeachers.forEach(data=>{
      data.contributedHours=parseInt(data.contributedHours+'');
    });
    return this.groupInfoTeachers;
  }
}
