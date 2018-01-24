import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-group-overview-table',
  templateUrl: './group-overview-table.component.html',
  styleUrls: ['./group-overview-table.component.css']
})
export class GroupOverviewTableComponent implements OnInit {

  @Input('studentsInfo') info: any;

  constructor() {
  }

  ngOnInit() {
  }

  bbb(info: any) {
    console.log(info);
  }

}
