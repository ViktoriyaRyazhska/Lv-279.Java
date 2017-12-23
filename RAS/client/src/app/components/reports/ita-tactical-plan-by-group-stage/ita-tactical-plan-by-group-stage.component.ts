import {Component, Injectable, OnInit, ViewChild} from '@angular/core';
import {ItaTacticalPlanByGroupStageService} from "./ita-tactical-plan-by-group-stage.service";
import {MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";
import {log} from "util";


@Component({
  selector: 'app-ita-tactical-plan-by-group-stage',
  templateUrl: './ita-tactical-plan-by-group-stage.component.html',
  styleUrls: ['./ita-tactical-plan-by-group-stage.component.css'],
  providers: [ItaTacticalPlanByGroupStageService]
})

@Injectable()
export class ItaTacticalPlanByGroupStageComponent implements OnInit {

  itaTacticalPlanByGroupStageReports = [
    {dataSource: new MatTableDataSource(), name: "List of planned launches of group (next 2 monthes)", totalStudentStatuses: [0,0,0,0]},
    {dataSource: new MatTableDataSource(), name: "In Process", totalStudentStatuses: [0,0,0,0]},
    {dataSource: new MatTableDataSource(), name: "Offering", totalStudentStatuses: [0,0,0,0]},
    {dataSource: new MatTableDataSource(), name: "Graduated", totalStudentStatuses: [0,0,0,0]},
    {dataSource: new MatTableDataSource(), name: "List of planned releases", totalStudentStatuses: [0,0,0,0]}
  ]

  dataToSave : any  = [];
  displayedColumns = ['Year', 'Month','Group ID', 'Group/Group feedbacks', 'CG', 'Profile', 'Location', '#,requested'
    , '#,study in progress', '#,graduated', '#,hired', 'Group start Date', 'Group finish Date', 'Trainer', 'Comment', 'Payment status'];
  @ViewChild(MatSort) sort: MatSort;


  constructor(private itaTacticalPlanByGroupStageService: ItaTacticalPlanByGroupStageService,
              private router:Router) {
  }

  ngOnInit() {
    this.itaTacticalPlanByGroupStageService.getAll().subscribe(
      data => {
        for (var i = 0; i < data.length; i++) {
          for( var j=0; j<data[i].length;j++){
            this.itaTacticalPlanByGroupStageReports[i].totalStudentStatuses[0]+= data[i][j].requested;
            this.itaTacticalPlanByGroupStageReports[i].totalStudentStatuses[1]+= data[i][j].studyInProgress;
            this.itaTacticalPlanByGroupStageReports[i].totalStudentStatuses[2]+= data[i][j].graduated;
            this.itaTacticalPlanByGroupStageReports[i].totalStudentStatuses[3]+= data[i][j].hired;
          }

          this.dataToSave[i]=data[i].sort((item1, item2) => {
            if (item1.startDate > item2.startDate) {
              return 1;
            } else {
              return -1;
            }
          });
          this.itaTacticalPlanByGroupStageReports[i].dataSource = new MatTableDataSource(this.dataToSave[i]);
          this.itaTacticalPlanByGroupStageReports[i].dataSource.sort = this.sort;
        }
      },
      error => {
        if (error.status===403) {
          this.router.navigate(['ang/error']);
        }
        console.log(error)
      }
    );
  console.log(this.itaTacticalPlanByGroupStageReports);
  }


}
