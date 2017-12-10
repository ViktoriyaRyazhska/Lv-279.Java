import { Component, OnInit } from '@angular/core';
import {ReportsService} from '../reports.service';
import {ChListGr} from "./ChListGr";

@Component({
  selector: 'app-check-list-by-groups',
  templateUrl: './check-list-by-groups.component.html',
  styleUrls: ['./check-list-by-groups.component.css'],
  providers: [ReportsService]
})
export class CheckListByGroupsComponent implements OnInit {
  groups: ChListGr;

  constructor(private reportsService: ReportsService) { }

  ngOnInit() {
    this.reportsService.getAllForCheckListReport().subscribe(
      data => {
        this.groups = data;
      },
      error => console.log(error)
    );
  }

}
