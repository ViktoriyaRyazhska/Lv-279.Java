import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import {DialogComponent} from "../../../group/dialog/dialog.component";
import {MatDialog} from "@angular/material";
import {StudentDialogComponent} from "../student-dialog/student-dialog.component";
import {StudentFeedback} from "../../../../models/feedbacks/student.model";

@Component({
  selector: 'app-group-overview-table',
  templateUrl: './group-overview-table.component.html',
  styleUrls: ['./group-overview-table.component.css']
})
export class GroupOverviewTableComponent implements OnInit {
  stDialInfo: any[];
  selectedStudent: any;
  studentsArray: any[];

  showDialogWindow = false;

  constructor(public dialog: MatDialog) {
  }

  ngOnInit() {
  }

  showReportTable(info: any) {
    info.forEach(student => student.user.firstName = student.user.firstName + ' ' + student.user.lastName);
    this.stDialInfo = info;
    this.studentsArray = this.stDialInfo;
  }

  showDialog(id: any): void {
    this.stDialInfo = this.studentsArray.filter(inf => inf.user.id === id);
    this.selectedStudent = this.stDialInfo[0];

    let dialogRef = this.dialog.open(StudentDialogComponent, {
      data: {selectedStudent: this.stDialInfo[0]}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

}
