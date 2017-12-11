import { Component, OnInit } from '@angular/core';
import {Tests} from "../../models/tests";
import {TestsService} from "../../services/tests-names/tests.service";
import {Http, Response} from '@angular/http';
import {map} from "rxjs/operator/map";

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
  defaultTestName : string;

  constructor(private testNamesService  : TestsService) {}

  ngOnInit() {
    this.testNamesService.getAll().subscribe(data => {
      console.log(data)
      this.tests = data
    });
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
      this.defaultTestName = 'test' + (this.tests.length+1);
      this.tests.push(new Tests(this.defaultTestName,10));

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
