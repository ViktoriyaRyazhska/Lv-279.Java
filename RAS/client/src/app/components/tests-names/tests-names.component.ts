import { Component, OnInit } from '@angular/core';
import {Tests} from "../../models/tests";
import {TestsService} from "../../services/tests-names/tests.service";
import {Http, Response} from '@angular/http';

@Component({
  selector: 'app-tests-names',
  templateUrl: './tests-names.component.html',
  styleUrls: ['./tests-names.component.css']
})
export class TestsNamesComponent implements OnInit {

  static counter : number = 1;
  name: string;
  mp: number;
  tests : Tests[];
  testNames : any[];
  max_points : any[];
  //noinspection TypeScriptUnresolvedFunction
  testIndex = Array(TestsNamesComponent.counter).fill(1).map((x,i)=>i);

  constructor(
    private testNamesService  : TestsService
  )
  { }


  ngOnInit() {
    this.testNamesService.getAll().subscribe(resp => {
      this.name = resp.testName;
    });


    // this.testNamesService.getAll().subscribe(
    //   data => {
    //     this.tests = data;
    //   },
    //   error => console.log(error)
    // );
  }


  save(name : string, mp : number) {
    if(name==null || name==undefined || name.trim()=="")
      return;
    if(mp==null || mp==undefined)
      return;
    // this.tests.push(new Tests(name, mp));
  }


  addTest() {
    if(TestsNamesComponent.counter>=12) {
      return;
    }
    else
    {
      TestsNamesComponent.counter++;
      //noinspection TypeScriptUnresolvedFunction
      this.testIndex = Array(TestsNamesComponent.counter).fill(1).map((x,i)=>i);
    }
  }



  // removeTest(name : string, mp : number) {
  //   TestsNamesComponent.counter--;
  //   //noinspection TypeScriptUnresolvedFunction
  //   this.testIndex = Array(TestsNamesComponent.counter).fill(1).map((x,i)=>i);
  //
  //   const indexName = this.tests.testName.indexOf(name);
  //   const indexMP = this.tests.max_point.indexOf(mp);
  //
  //
  //   if(indexMP!=-1) {
  //     this.tests.max_point.splice(indexMP,1);
  //   }
  //   if(indexName!=-1) {
  //     this.tests.testName.splice(indexName,1);
  //   }
  // }
}
