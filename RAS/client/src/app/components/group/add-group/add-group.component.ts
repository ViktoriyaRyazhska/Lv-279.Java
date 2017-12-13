import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/map';
import {AddGroupService} from "./add-group.service";
import {HistoryService} from "../../history/history.service";
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Group} from "./group.model";

@Component({
  selector: 'app-add-group',
  templateUrl: './add-group.component.html',
  styleUrls: ['./add-group.component.css'],
  providers: [HistoryService]
})
export class AddGroupComponent implements OnInit {
  private signupForm: FormGroup;

  private group: Group;

  academyStatus: any[];
  city: any[];
  commonDirection: any[];
  direction: any[];
  profile: any[];

  private defaultInvalidInput: string = 'No data entered. Group will not be save';

  constructor(private addGroupService: AddGroupService) {}


  ngOnInit() {
    this.group = new Group();

    this.addGroupService.getAll().subscribe(resp => {
      this.academyStatus = resp.academyStages;
      this.city = resp.cityNames;
      this.commonDirection = resp.direction;
      this.direction = resp.technologie;
      this.profile = resp.profile;
    });

    this.signupForm = new FormGroup({
      'groupInfoFormControl': new FormControl(this.group.grName, Validators.required),
      'nameForSiteFormControl': new FormControl(this.group.nameForSite, [Validators.required]),
      'academyStagesId': new FormControl(this.group.academyStagesId),
      'cityId': new FormControl(this.group.cityId),
      'startDateFormControl': new FormControl(this.group.startDate),
      'endDateFormControl': new FormControl(this.group.endDate),
      'commonDirectionFormControl': new FormControl(this.group.directionId, Validators.required),
      'directionFormControl': new FormControl(this.group.technologieId, Validators.required),
      'profileInfoFormControl': new FormControl(this.group.profileId),
      'studentPlannedToGraduate': new FormControl(this.group.studentPlannedToGraduate),
      'studentPlannedToEnrollment': new FormControl(this.group.studentPlannedToEnrollment),
      'studentActualFromControl': new FormControl(this.group.studentActual)
    });
  }

  isFormValid(): boolean{
    return this.signupForm.get('nameForSiteFormControl').valid;
  }

  saveGroup() {
    if(this.isFormValid()){
      this.group.setDataFromFormControl(this.signupForm);
      this.isFormValid();
      this.addGroupService.post(this.group);
    }else{

    }

  }

  // setDataToForm(){
  //   this.signupForm.setValue({
  //     'groupInfoFormControl': ,
  //     'nameForSiteFormControl': ,
  //     'academyStagesId': ,
  //     'cityId': ,
  //     'startDateFormControl': ,
  //     'endDateFormControl': ,
  //     'commonDirectionFormControl': ,
  //     'directionFormControl': ,
  //     'profileInfoFormControl': ,
  //     'studentPlannedToGraduate': ,
  //     'studentPlannedToEnrollment':
  //   });
  // }


}
