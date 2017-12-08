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


  constructor(private itaTacticalPlanByGroupStageService: ItaTacticalPlanByGroupStageService) {
  }


  ngOnInit() {
    this.itaTacticalPlanByGroupStageService.getAll().subscribe(
      data => {
        this.itaTacticalPlanByGroupStage = data;
      },
      error => {
        console.log(error)
      }
    );
  }

}
