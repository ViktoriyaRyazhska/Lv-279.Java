import { Component, OnInit } from '@angular/core';
import {Tests} from "../../models/tests";
import {TestsService} from "../../services/tests-names/tests.service";
import {ActivatedRoute} from "@angular/router";
import {Constants} from "./Constants";

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
    this.testNamesService.addTests(this.tests,this.groupId);
    console.log(this.tests);
  }

  addTest() {
    if(this.tests.length>=Constants.MaxValueOfTests) {
      return;
    }
    else {
      this.tests.push(new Tests((Constants.DefaultTestName+(this.tests.length)),Constants.DefaultMaxScore));
    }
  }

  removeTest(test : Tests) {
    const indexOfTestToRemove = this.tests.indexOf(test);
    if(indexOfTestToRemove!=-1) {
      this.tests.splice(indexOfTestToRemove,1);
    }
  }
}
