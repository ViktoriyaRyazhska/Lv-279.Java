export class Tests {
  groupId : number;
  testMaxScore: number;
  testName: string;

  constructor(tstName:string,mp:number,){
    this.testMaxScore = mp;
    this.testName = tstName;
  }

}
