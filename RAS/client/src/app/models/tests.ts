import {FormGroup} from "@angular/forms";
export class Tests {
  testId : number;
  groupId : any;
  testMaxScore: number;
  testName: string;
  removed: boolean;

  constructor(tstName:string,mp:number){
    this.testMaxScore = mp;
    this.testName = tstName;
  }

  setTestRowsWithFormGroup(item : any) {
    this.testMaxScore = item.get('testMaxScore').value;
    this.testName = item.get('testName').value;
    if(item.get('testId').value!=null) {
      this.testId = item.get('testId').value;
    }
    else this.testId = null;
    if(item.get('removed').value!=null) {
      this.removed = item.get('removed').value;
    }
    else this.removed = false;
  }

  isRemoved() : boolean {
    return this.removed;
  }


}
