import {Component, Input, OnInit} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {EmployeeAddComponent} from "./employee-add/employee-add.component";
import {Employee} from "./Employee";
import {EmployeeService} from "./employee.service";
import {GroupInfoTeachers} from "./GroupInfoTeachers";
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  @Input() groupId: number;
  private displayUsersList: boolean;
  private employees: Employee[];
  private selectedEmployee: Employee[];
  private acceptedEmployees = [];
  private value:string;


  constructor(private employeeService:EmployeeService) {}

  ngOnInit() {
    this.employeeService.findAllExperts().subscribe(data=>{
      this.employees=data;
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
    console.log(this.selectedEmployee);
    console.log(this.convertToArrayOfGroupInfoTeachers(this.selectedEmployee));
    this.employeeService.assignEmployee(this.convertToArrayOfGroupInfoTeachers(this.selectedEmployee)).subscribe(data=>{
      this.selectedEmployee = [];
      this.displayUsersList = false;
    });
    // this.selectedEmployee = [];
    // this.displayUsersList = false;
  }

  convertToArrayOfGroupInfoTeachers(selectedEmployee: Employee[]): GroupInfoTeachers[]{
   for (let i=0;i<selectedEmployee.length;i++){
     this.acceptedEmployees[i]=new GroupInfoTeachers();
     this.acceptedEmployees[i].employee = this.selectedEmployee[i].employeeId;
     this.acceptedEmployees[i].academy=586;
   }
    return this.acceptedEmployees;
  }
}
