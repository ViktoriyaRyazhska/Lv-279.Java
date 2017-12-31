import { Component, OnInit } from '@angular/core';
import {BsModalRef} from "ngx-bootstrap";
import {EmployeeService} from "../employee.service";
import {Employee} from "../Employee";

@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.css']
})
export class EmployeeAddComponent implements OnInit {

  title: string;
  fullList: Employee[];
  list: Employee[]=[];

  maxSize: number = 5;
  itemsPerPage: number = 10;
  bigTotalItems: number;
  bigCurrentPage: number = 1;
  numPages: number = 0;

  constructor(public bsModalRef: BsModalRef,
              private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employeeService.findAllExperts().subscribe(data =>{
      this.fullList=data;
      this.list=data.slice(0,this.itemsPerPage);
      this.bigTotalItems=data.length;
    });
  }

  getCurrentList(event: any,fullList): void{
    var j=0;
    this.list=[];
    for (let i=(event.page-1)*event.itemsPerPage;i<event.page*event.itemsPerPage;i++){
      if (i==fullList.length){
        break;
      }
      this.list[j]=fullList[i];
      j++;
    }
  }
}
