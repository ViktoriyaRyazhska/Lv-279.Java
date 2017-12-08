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
  allData: ChListGr;
  tstVisible: any;
  some: any;
  tstCapt = '+';

  constructor(private reportsService: ReportsService) { }

  ngOnInit() {
    this.reportsService.getAllForCheckListReport().subscribe(
      data => {
        this.allData = data;
      },
      error => console.log(error)
    );
  }

  tstBtnClick(index: number): void {
    this.tstVisible = !this.tstVisible;
    if (this.tstVisible) {
      this.tstCapt = '-';
    } else {
      this.tstCapt = '+';
    }
  }

}
