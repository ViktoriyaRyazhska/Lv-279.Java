import { Component, OnInit } from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {EmployeeAddComponent} from "./employee-add/employee-add.component";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  bsModalRef: BsModalRef;
  list: any[] = [1,2,3,4,5,6];

  constructor(private modalService: BsModalService) {}

  ngOnInit() {
  }

  openModalWithComponent() {
    this.bsModalRef = this.modalService.show(EmployeeAddComponent);
    this.bsModalRef.content.title = 'Modal with component';
    // this.bsModalRef.content.list = this.list;
  }
}
