import {FormGroup} from '@angular/forms';

export class GroupOverview {
  groupName: string = null;
  endDate = null;
  cityId: number = null;
  directionId: number = null;

  constructor(values: Object = {}) {
    Object.assign(this, values);
  }

  setDataFromFormControl(form: FormGroup) {
    this.groupName = form.get('groupInfoFormControl').value;
    this.cityId = form.get('cityId').value;
    this.endDate = new Date(form.get('endDateFormControl').value).getTime();
    this.directionId = form.get('commonDirectionFormControl').value;
  }

  setDataToGroup(group: any) {
    this.groupName = group.groupName;
    this.cityId = group.cityId;
    this.endDate = new Date(group.endDate);
    this.directionId = group.directionId;
  }


}
