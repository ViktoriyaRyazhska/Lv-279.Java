import {Component, Input, OnInit} from '@angular/core';
import { Tests } from "../../models/tests";
import { TestsService } from "../../services/tests-names/tests.service";
import { ActivatedRoute } from "@angular/router";
import { Constants } from "./Constants";
import {FormBuilder, FormGroup, Validators, FormArray, FormControl} from '@angular/forms';

@Component({
  selector: 'app-tests-names',
  templateUrl: './tests-names.component.html',
  styleUrls: ['./tests-names.component.css']
})
export class TestsNamesComponent implements OnInit {
  @Input() groupId: number;

  // groupId : number;
  tests : Tests[];
  static counter : number = 1;
  rForm: FormGroup;
  testRows: FormArray;

  constructor(
    private testNamesService : TestsService,
    private route: ActivatedRoute,
    private fb: FormBuilder,
  ) {
    this.groupId = +this.route.snapshot.params['id'];
    this.rForm = new FormGroup({
      testRows: this.fb.array([])
    });
  }

  ngOnInit() {
    this.testNamesService.getAll(this.groupId).subscribe(data => {
      console.log(data);
      this.tests = data;
      TestsNamesComponent.counter = this.tests.length;

      if (TestsNamesComponent.counter<=0){
        this.createDefaultTests();
      }
      else {
        this.testRows = this.rForm.get('testRows') as FormArray;
        for (let i = 0; i < this.tests.length; i++) {
          this.testRows.push(this.createTestRow(this.tests[i]));
        }
      }
    });
  }

  createTestRow(test : Tests): FormGroup {
    return this.fb.group({
      'testName': new FormControl(test.testName, [Validators.required, Validators.maxLength(50)]),
      'testMaxScore': new FormControl(test.testMaxScore, [Validators.required, Validators.min(1), Validators.max(1000), Validators.pattern("^(0|[1-9][0-9]*)$")]),
      'testId': new FormControl(test.testId),
      'removed': new FormControl(test.removed),
    });
  }

  save() {
    if (this.isFormValid()) {
      this.tests = [];
      console.log(this.tests.length);
      for (let i = 0; i < this.testRows.length; i++) {
        let item = this.testRows.at(i);
        let test = new Tests(item.get('testName').value, item.get('testMaxScore').value);
        test.setTestRowsWithFormGroup(item);
        this.tests.push(test);
      }
    }
    this.testRows.controls = [];
    console.log(this.testRows.length);
    this.testNamesService.addTests(this.tests, this.groupId).subscribe(() => {
      this.tests = null;
      this.ngOnInit()
    });
  }

  isFormValid(): boolean {
    return this.rForm.valid;
  }

  addTest() {
    if(TestsNamesComponent.counter>=Constants.MaxValueOfTests) {
      return;
    }
    else {
      this.testRows = this.rForm.get('testRows') as FormArray;
      var testNum = ++TestsNamesComponent.counter;
      let test : Tests = new Tests((Constants.DefaultTestName+(testNum)),Constants.DefaultPoint);
      this.testRows.push(this.createTestRow(test));
    }
  }

  removeTest(index : number, item : any) {
    TestsNamesComponent.counter--;
    if(index>=0) {
      let test : Tests = new Tests('',0);
      item.get('removed').value = true;
      test.setTestRowsWithFormGroup(item);
      this.testRows.controls.splice(index,1,this.createTestRow(test));
    }
  }

  cancelChanges () {
    this.testRows.controls = [];

    TestsNamesComponent.counter = this.tests.length;
    if(TestsNamesComponent.counter<=0)
    {
      this.createDefaultTests();
    }
    else {
      for (let i = 0; i < this.tests.length; i++) {
        this.testRows.push(this.createTestRow(this.tests[i]));
      }
    }
  }

  createDefaultTests(){
    for(let i=0;i<5;i++) {
      this.addTest();
    }
  }
}

