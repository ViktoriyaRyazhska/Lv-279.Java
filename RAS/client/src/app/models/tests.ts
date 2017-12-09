export class Tests {
  counter : number;
  max_point: number[];
  testName: string[];

  constructor(mp:number,tstName:string){
    this.max_point.push(mp);
    this.testName.push(tstName);
  }

}
