import {Component, OnInit} from '@angular/core';
import {ItaTacticalPlanByGroupStageService} from "./ita-tactical-plan-by-group-stage.service";
import {HistoryService} from "../history/history.service";

@Component({
  selector: 'app-ita-tactical-plan-by-group-stage',
  templateUrl: './ita-tactical-plan-by-group-stage.component.html',
  styleUrls: ['./ita-tactical-plan-by-group-stage.component.css'],
  providers: [ItaTacticalPlanByGroupStageService]
})
export class ItaTacticalPlanByGroupStageComponent implements OnInit {

  itaTacticalPlanByGroupStage: Array<any>;
  planedGroupForTwoMoth: Array<any>;
  groupsInProces: Array<any>;
  groupsOffering: Array<any>;
  groupsGraduated: Array<any>;


  constructor(private itaTacticalPlanByGroupStageService: ItaTacticalPlanByGroupStageService) {
  }


  ngOnInit() {
    this.itaTacticalPlanByGroupStageService.getAll().subscribe(
      data => {
        this.itaTacticalPlanByGroupStage = data;
        this.groupsGraduated = this.itaTacticalPlanByGroupStage.pop();
        this.groupsOffering = this.itaTacticalPlanByGroupStage.pop();
        this.groupsInProces = this.itaTacticalPlanByGroupStage.pop();
        this.planedGroupForTwoMoth = this.itaTacticalPlanByGroupStage.pop()
      },
      error => {
        console.log(error)
      }
    );
  }

}
