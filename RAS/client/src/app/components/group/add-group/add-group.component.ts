import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/map';
import {AddGroupService} from "./add-group.service";
import {HistoryService} from "../../history/history.service";
import {FormControl, FormGroup, Validators} from '@angular/forms';



@Component({
  selector: 'app-add-group',
  templateUrl: './add-group.component.html',
  styleUrls: ['./add-group.component.css'],
  providers: [HistoryService]
})
export class AddGroupComponent implements OnInit {
  signupForm: FormGroup;

  academyStages: any[];
  cityNames: any[];
  direction: any[];
  technologie: any[];
  profile: any[];

  technologyModel: any;

  defaultStudentActual: number = 0;
  defaultStudentsPlannedToGraduate: number = 0;
  defaultStudentsPlannedToEnrollment: number = 0;

  defaultCity: any[];
  defaultInvalidInput: string = 'No data entered. Group will not be save';

  constructor(private addGroupService: AddGroupService) {
  }

  ngOnInit() {
    this.addGroupService.getAll().subscribe(resp => {
      this.academyStages = resp.academyStages;
      this.cityNames = resp.cityNames;
      this.direction = resp.direction;
      this.profile = resp.profile;
      this.technologie = resp.technologie;
    });

    this.signupForm = new FormGroup({
      'groupInfo': new FormControl(null, Validators.required),
      'nameForSite': new FormControl(null, [Validators.required]),
      'academyStageId': new FormControl('1'),
      'cityId': new FormControl('1'),
      'startDateFormControl': new FormControl(),
      'endDateFormControl': new FormControl(),
      'commonDirection': new FormControl(),
      'technolgyId': new FormControl(),
      'profileInfoFormControl': new FormControl(),
      'SCTGraduate': new FormControl(),
      'SCTEnrollment': new FormControl()
    });
  }

  saveGroup() {
    console.log(this.signupForm);
  }


}
