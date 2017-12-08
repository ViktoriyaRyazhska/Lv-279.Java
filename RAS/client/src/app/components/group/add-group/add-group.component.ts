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

  academyStatus: any[];
  city: any[];
  commonDirection: any[];
  direction: any[];
  profile: any[];

  defaultStudentActual: number = 0;
  defaultStudentsPlannedToGraduate: number = 0;
  defaultStudentsPlannedToEnrollment: number = 0;

  defaultInvalidInput: string = 'No data entered. Group will not be save';

  constructor(private addGroupService: AddGroupService) {
  }

  ngOnInit() {
    this.addGroupService.getAll().subscribe(resp => {
      this.academyStatus = resp.academyStages;
      this.city = resp.cityNames;
      this.commonDirection = resp.direction;
      this.direction = resp.technologie;
      this.profile = resp.profile;
    });

    this.signupForm = new FormGroup({
      'groupInfoFormControl': new FormControl(null, Validators.required),
      'nameForSiteFormControl': new FormControl(null, [Validators.required]),
      "academyStatusId": new FormControl('1'),
      'cityId': new FormControl('1'),
      'startDateFormControl': new FormControl(),
      'endDateFormControl': new FormControl(),
      'commonDirectionFormControl': new FormControl(),
      "directionFormControl": new FormControl(),
      'profileInfoFormControl': new FormControl(),
      "sctGraduate": new FormControl(),
      "sctEnrollment": new FormControl()
    });
  }

  saveGroup() {
    console.log(this.signupForm);
  }

  // setDataToForm(){
  //   this.signupForm.setValue({
  //     'groupInfoFormControl': ,
  //     'nameForSiteFormControl': ,
  //     'academyStatusId': ,
  //     'cityId': ,
  //     'startDateFormControl': ,
  //     'endDateFormControl': ,
  //     'commonDirectionFormControl': ,
  //     'directionFormControl': ,
  //     'profileInfoFormControl': ,
  //     'sctGraduate': ,
  //     'sctEnrollment':
  //   });
  // }


}
