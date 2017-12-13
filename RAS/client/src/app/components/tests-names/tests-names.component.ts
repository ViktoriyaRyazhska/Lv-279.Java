import { Component, OnInit, ViewChild } from '@angular/core';
import {Tests} from "../../models/tests";
import {TestsService} from "../../services/tests-names/tests.service";
import {ActivatedRoute} from "@angular/router";
import {Constants} from "./Constants";
import {MatPaginator, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-tests-names',
  templateUrl: './tests-names.component.html',
  styleUrls: ['./tests-names.component.css']
})
export class TestsNamesComponent implements OnInit {
  groupId : number;
  tests : Tests[];
  static counter : number = 1;
  testsToDelete : Tests[] = [];

  constructor(
    private testNamesService : TestsService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.groupId = +this.route.snapshot.paramMap.get('id');
    this.testNamesService.getAll(this.groupId).subscribe(data => {
      console.log(data)
      this.tests = data
      TestsNamesComponent.counter = this.tests.length;
    });
  }


  save() {
    this.testNamesService.addTests(this.tests, this.groupId);
    console.log(this.tests);
    this.ngOnInit();
  }


  addTest() {
    if(TestsNamesComponent.counter>=Constants.MaxValueOfTests) {
      return;
    }
    else {
      TestsNamesComponent.counter++;
      var testNum = TestsNamesComponent.counter;
      this.tests.push(new Tests((Constants.DefaultTestName+(testNum)),Constants.DefaultMaxScore));
    }
  }

  removeTest(test : Tests) {
    TestsNamesComponent.counter--;
    const indexOfTestToRemove = this.tests.indexOf(test);
    if(indexOfTestToRemove!=-1) {
      if(test.testId==null){
        this.tests.splice(indexOfTestToRemove,1);
      }
      else {
        test.testMaxScore = Constants.REMOVE;
        test.testName = "remove";
        this.testsToDelete.push(test);
        this.tests.splice(indexOfTestToRemove, 1, test);
      }
    }
  }
}
