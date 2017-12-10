import {Component, OnInit} from '@angular/core';
import {ItaTacticalPlanByGroupStageService} from "./ita-tactical-plan-by-group-stage.service";
import {HistoryService} from "../history/history.service";
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'app-ita-tactical-plan-by-group-stage',
  templateUrl: './ita-tactical-plan-by-group-stage.component.html',
  styleUrls: ['./ita-tactical-plan-by-group-stage.component.css'],
  providers: [ItaTacticalPlanByGroupStageService]
})
export class ItaTacticalPlanByGroupStageComponent implements OnInit {

  itaTacticalPlanByGroupStageReports = [
    {report: [], name: "List of planned launches of group (next 2 monthes)"},
    {report: [], name: "In Process"},
    {report: [], name: "Offering"},
    {report: [], name: "Graduated"}
  ]


  constructor(private itaTacticalPlanByGroupStageService: ItaTacticalPlanByGroupStageService) {
  }

  ngOnInit() {
    this.itaTacticalPlanByGroupStageService.getAll().subscribe(
      data => {
        for (var i = 0; i < data.length; i++) {
          this.itaTacticalPlanByGroupStageReports[i].report = data[i];
        }
       // console.log(this.itaTacticalPlanByGroupStageReports);
      },
      error => {
        console.log(error)
      }
    );
  }

  //
  //
  // ngOnInit() {
  //   this.itaTacticalPlanByGroupStageService.getAll().subscribe(
  //     data => {
  //       this.itaTacticalPlanByGroupStage = data;
  //       this.groupsGraduated = this.itaTacticalPlanByGroupStage.pop();
  //       this.groupsOffering = this.itaTacticalPlanByGroupStage.pop();
  //       this.groupsInProces = this.itaTacticalPlanByGroupStage.pop();
  //       this.planedGroupForTwoMoth = this.itaTacticalPlanByGroupStage.pop()
  //     },
  //     error => {
  //       console.log(error)
  //     }
  //   );
  // }

}
