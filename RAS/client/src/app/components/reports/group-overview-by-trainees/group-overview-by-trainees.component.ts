import {Component, OnInit} from '@angular/core';
import {GroupOverviewService} from "./group-overview.service";
import {FormControl, FormGroup} from "@angular/forms";
import {GroupOverview} from "./group-overview.model";
import {GroupInfo} from "./group-info.model";

@Component({
  selector: 'app-group-overview-by-trainees',
  templateUrl: './group-overview-by-trainees.component.html',
  styleUrls: ['./group-overview-by-trainees.component.css'],
  providers: [GroupOverviewService]
})
export class GroupOverviewByTraineesComponent implements OnInit {
  endYears = [];
  groupArray = [];
  cityNames: any[];
  commonDirection: any[];

  signupForm: FormGroup;
  group: GroupOverview;

  groupInfo: GroupInfo;

  constructor(private groupOverview: GroupOverviewService) {
  }

  ngOnInit() {
    this.group = new GroupOverview();

    this.groupOverview.getAll().subscribe(
      data => {
        this.cityNames = data.cityNames;
        this.commonDirection = data.direction;
        for (let elem of data.groupNames) {
          this.groupInfo = new GroupInfo();
          this.groupInfo.groupName = elem.groupName;
          if (elem.academy.directions != null) {
            this.groupInfo.directionId = elem.academy.directions.directionId;
          }
          if (elem.academy.city != null) {
            this.groupInfo.cityId = elem.academy.city.cityId;
          }
          elem.academy.endDate = elem.academy.endDate.split('-')[0];
          this.groupInfo.endDate = elem.academy.endDate;
          this.groupArray.push(this.groupInfo);

          if (!this.endYears.includes(elem.academy.endDate)) {
            this.endYears.push(elem.academy.endDate);
          }
        }
      },
      error => console.log(error)
    );
    this.formGroupOnInit();
  }

  formGroupOnInit() {
    this.signupForm = new FormGroup({
      'groupNameFormControl': new FormControl(this.group.groupName),
      'cityIdFormControl': new FormControl(this.group.cityId),
      'endDateFormControl': new FormControl(this.group.endDate),
      'commonDirectionFormControl': new FormControl(this.group.directionId)
    });
  }

  showReport() {

  }
}
