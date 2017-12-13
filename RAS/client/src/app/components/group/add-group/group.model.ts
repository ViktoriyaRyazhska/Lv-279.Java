import {FormGroup} from '@angular/forms';

export class Group {

  grName: string = null;
  nameForSite: string = null;
  academyStagesId: number = 1;
  startDate: number = null;
  endDate: number = null;
  cityId: number = 1;
  directionId: number = null;
  technologieId: number = null;
  profileId: number = null;
  studentPlannedToGraduate: number = 0;
  studentPlannedToEnrollment: number = 0;
  studentActual: number = 0;

  setDataFromFormControl(form: FormGroup){
    this.grName = form.get('groupInfoFormControl').value;
    this.nameForSite = form.get('nameForSiteFormControl').value;
    this.academyStagesId = form.get('academyStagesId').value;
    this.cityId = form.get('cityId').value;
    this.startDate = new Date(form.get('startDateFormControl').value).getTime();
    this.endDate = new Date(form.get('endDateFormControl').value).getTime();
    this.directionId = form.get('commonDirectionFormControl').value;
    this.technologieId = form.get('directionFormControl').value;
    this.profileId = form.get('profileInfoFormControl').value;
    this.studentPlannedToGraduate = form.get('studentPlannedToGraduate').value;
    this.studentPlannedToEnrollment = form.get('studentPlannedToEnrollment').value;
    this.studentActual = form.get('studentActualFromControl').value;
  }

}
