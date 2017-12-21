import { Component, OnInit } from '@angular/core';
import { Tests } from "../../models/tests";
import { TestsService } from "../../services/tests-names/tests.service";
import { ActivatedRoute } from "@angular/router";
import { Constants } from "./Constants";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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
  addTestsStatus : number;
  rForm: FormGroup;

  constructor(
    private testNamesService : TestsService,
    private route: ActivatedRoute,
    private fb: FormBuilder,
  ) {
    this.groupId = +this.route.snapshot.params['id'];

    this.rForm = this.fb.group({
      'testName' : [null, Validators.required],
      'testMaxPoint' : [null, Validators.compose([Validators.required, Validators.minLength(1), Validators.maxLength(3),Validators.max(1000),Validators.min(0)])]
    });

  }

  ngOnInit() {
    this.testNamesService.getAll(this.groupId).subscribe(data => {
      console.log(data+"new data")
      this.tests = data
      TestsNamesComponent.counter = this.tests.length;
    });
  }

  save() {
    this.testNamesService.addTests(this.tests, this.groupId).subscribe(() => {
      this.tests = null;
      this.ngOnInit()
    });
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
