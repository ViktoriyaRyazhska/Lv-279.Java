import { Component, OnInit } from '@angular/core';
import {ItaTacticalPlanByGroupStageService} from "./ita-tactical-plan-by-group-stage.service";
import {AddGroupService} from "../group/add-group/add-group.service";

@Component({
  selector: 'app-ita-tactical-plan-by-group-stage',
  templateUrl: './ita-tactical-plan-by-group-stage.component.html',
  styleUrls: ['./ita-tactical-plan-by-group-stage.component.css']
})
export class ItaTacticalPlanByGroupStageComponent implements OnInit {

  tacticalRepors: Array<any>;


  constructor(private itaTacticalPlanByGroupStageService: ItaTacticalPlanByGroupStageService, private addGroupService: AddGroupService) {
  }

  criteria = {};

  groupStatuses: any[];
  locations: any[];
  groupCompotences: any[];
  isShow = false;

  paymentStatuses = [
    {id: 1, name: 'Open group'},
    {id: 2, name: 'Founded by Softserve'}];


  submitForm(form: HTMLFormElement) {
    this.criteria = form.value;
  }

  showReport() {
    this.isShow = true;
    console.log(this.isShow)
  }

  ngOnInit() {
    this.itaTacticalPlanByGroupStageService.getAll().subscribe(
      data => {
        this.tacticalRepors = data;
      },
      error => {
        console.log(error)
      }
    );
    this.addGroupService.getAll().subscribe(resp => {
      this.groupStatuses = resp.academyStages;
      this.locations = resp.cityNames;
      this.groupCompotences = resp.technologie;
    });
  }

}
