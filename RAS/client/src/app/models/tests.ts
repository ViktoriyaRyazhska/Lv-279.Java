import {FormGroup} from "@angular/forms";
export class Tests {
  testId : number;
  groupId : any;
  testMaxScore: number;
  testName: string;
  removed: boolean;
  testSequenceNum: number;

  constructor(tstName:string,mp:number){
    this.testMaxScore = mp;
    this.testName = tstName;
  }

  setTestRows(item : any) {
    this.testMaxScore = item.testMaxScore;
    this.testName = item.testName;
    if(item.testId!=null) {
      this.testId = item.testId;
    }
    else this.testId = null;
    if(item.removed!=null) {
      this.removed = item.removed;
    }
    else this.removed = false;
    if(item.testSequenceNum != null) {
      this.testSequenceNum = item.testSequenceNum;
    }
    else this.testSequenceNum = null;
  }

    isRemoved():boolean {
    return this.removed;
  }


}
