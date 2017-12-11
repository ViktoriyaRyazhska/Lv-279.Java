import {FormControl, FormGroup, Validators} from '@angular/forms';


export class Group {

  grName: string = null;
  nameForSite: string = null;
  academyStagesId: number = 1;
  startDate: string = null;
  endDate: string = null;
  cityId: number = 1;
  directionId: number;
  technologieId: number;
  profileId: number;
  studentPlannedToGraduate: number = 0;
  studentPlannedToEnrollment: number = 0;
  studentActual: number = 0;

  setDataFromFormControl(form: FormGroup){
    this.grName = form.get('groupInfoFormControl').value;
    this.nameForSite = form.get('nameForSiteFormControl').value;
    this.academyStagesId = form.get('academyStagesId').value;
    this.cityId = form.get('cityId').value;
    this.startDate = form.get('startDateFormControl').value;
    this.endDate = form.get('endDateFormControl').value;
    this.directionId = form.get('commonDirectionFormControl').value;
    this.technologieId = form.get('directionFormControl').value.technologyId;
    this.profileId = form.get('profileInfoFormControl').value;
    this.studentPlannedToGraduate = form.get('studentPlannedToGraduate').value;
    this.studentPlannedToEnrollment = form.get('studentPlannedToEnrollment').value;
    this.studentActual = form.get('studentActualFromControl').value;
  }

}
