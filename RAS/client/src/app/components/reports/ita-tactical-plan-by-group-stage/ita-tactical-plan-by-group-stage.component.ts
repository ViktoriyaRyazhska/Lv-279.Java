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

  // itaTacticalPlanByGroupStageReports = [
  //   {dataSource: new MatTableDataSource(), name: "List of planned launches of group (next 2 monthes)", totalStudentStatuses: [0,0,0,0]},
  //   {dataSource: new MatTableDataSource(), name: "In Process", totalStudentStatuses: [0,0,0,0]},
  //   {dataSource: new MatTableDataSource(), name: "Offering", totalStudentStatuses: [0,0,0,0]},
  //   {dataSource: new MatTableDataSource(), name: "Graduated", totalStudentStatuses: [0,0,0,0]},
  //   {dataSource: new MatTableDataSource(), name: "List of planned releases", totalStudentStatuses: [0,0,0,0]}
  // ]
  itaTacticalPlanByGroupStageReports = [
    {dataSource: new MatTableDataSource(), name: "List of planned launches of group (next 2 monthes)",totalStudentStatuses:[]},
    {dataSource: new MatTableDataSource(), name: "In Process",totalStudentStatuses:[]},
    {dataSource: new MatTableDataSource(), name: "Offering",totalStudentStatuses:[]},
    {dataSource: new MatTableDataSource(), name: "Graduated",totalStudentStatuses:[]},
    {dataSource: new MatTableDataSource(), name: "List of planned releases",totalStudentStatuses:[]}
  ]


  displayedColumns = ['Year', 'Month', 'Group ID', 'Group/Group feedbacks', 'CG', 'Profile', 'Location', '#,requested'
    , '#,study in progress', '#,graduated', '#,hired', 'Group start Date', 'Group finish Date', 'Trainer', 'Comment', 'Payment status'];
  @ViewChild(MatSort) sort: MatSort;


  constructor(private itaTacticalPlanByGroupStageService: ItaTacticalPlanByGroupStageService,
              private router: Router) {
  }

  ngOnInit() {
    this.itaTacticalPlanByGroupStageService.getAll().subscribe(
      data => {
        this.itaTacticalPlanByGroupStageReports[0].dataSource=this.transform(data.list_of_planned_next_2_monthes);
        this.itaTacticalPlanByGroupStageReports[0].totalStudentStatuses=this.calculateStudenStatus(data.list_of_planned_next_2_monthes)
        this.itaTacticalPlanByGroupStageReports[1].dataSource=this.transform(data.in_process);
        this.itaTacticalPlanByGroupStageReports[1].totalStudentStatuses=this.calculateStudenStatus(data.in_process);
        this.itaTacticalPlanByGroupStageReports[2].dataSource=this.transform(data.offering);
        this.itaTacticalPlanByGroupStageReports[2].totalStudentStatuses=this.calculateStudenStatus(data.offering);
        this.itaTacticalPlanByGroupStageReports[3].dataSource=this.transform(data.graduated);
        this.itaTacticalPlanByGroupStageReports[3].totalStudentStatuses=this.calculateStudenStatus(data.graduated);
        this.itaTacticalPlanByGroupStageReports[4].dataSource=this.transform(data.list_of_planned_releases);
        this.itaTacticalPlanByGroupStageReports[4].totalStudentStatuses=this.calculateStudenStatus(data.list_of_planned_releases);
      },
      error => {
        if (error.status === 403) {
          this.router.navigate(['ang/error']);
        }
        console.log(error)
      }
    );
    ;
  }

  transform(tabl= []){
    var dataToSave;
    dataToSave = new MatTableDataSource(tabl.sort(((item1, item2) => {
        if (item1.startDate > item2.startDate) {
          return 1;
        } else {
          return -1;
        }
      }
    )));
    dataToSave.sort=this.sort;
    return dataToSave;
  }
  calculateStudenStatus(tabl= []){
    var totalStudStatus = [0,0,0,0,0];
    for( var j=0; j<tabl.length;j++){
      totalStudStatus[0]+= tabl[j].requested;
      totalStudStatus[1]+= tabl[j].studyInProgress;
      totalStudStatus[2]+= tabl[j].graduated;
      totalStudStatus[3]+= tabl[j].hired;
    }
    return totalStudStatus;
    }

}
