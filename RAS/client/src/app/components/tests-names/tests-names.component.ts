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

  constructor(
    private testNamesService : TestsService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.groupId = +this.route.snapshot.paramMap.get('id');
    this.testNamesService.getAll(this.groupId).subscribe(data => {
      console.log(data)
      this.tests = data
    });
  }

  save() {
    this.testNamesService.addTests(this.tests, this.groupId);
    console.log(this.tests);
  }

  addTest() {
    if(this.tests.length>=Constants.MaxValueOfTests) {
      return;
    }
    else {
      var testNum = this.tests.length + 1;
      this.tests.push(new Tests((Constants.DefaultTestName+(testNum)),Constants.DefaultMaxScore));
    }
  }

  removeTest(test : Tests) {
    const indexOfTestToRemove = this.tests.indexOf(test);
    test.testName = <string>0;
    test.testMaxScore = 0;
    if(indexOfTestToRemove!=-1) {
      this.tests.splice(indexOfTestToRemove,1,test);
    }
  }
}
