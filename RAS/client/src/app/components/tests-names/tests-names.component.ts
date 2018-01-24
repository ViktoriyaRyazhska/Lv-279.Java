import {Component, Input, OnInit} from '@angular/core';
import { Tests } from "../../models/tests";
import { TestsService } from "../../services/tests-names/tests.service";
import { ActivatedRoute } from "@angular/router";
import { Constants } from "./Constants";
import {FormBuilder, PatternValidator, FormGroup, Validators, FormArray, FormControl} from '@angular/forms';
import {StudentsComponent} from "../students/students.component";

@Component({
  providers:[StudentsComponent],
  selector: 'app-tests-names',
  templateUrl: './tests-names.component.html',
  styleUrls: ['./tests-names.component.css']
})

export class TestsNamesComponent implements OnInit {
  @Input() groupId: number;
  @Input() studRef : StudentsComponent;
  @Input() techDirect : number;

  private tests : Tests[];
  static counter : number = 1;
  private invalidTest : Tests;
  private testRows: any[];
  private displayRemoveDialog : boolean;
  private displayValidationDialog : boolean;
  private currTest : any;
  private currIndex : number;
  private removedTests : Tests[];
  private testToSave : Tests[];


  constructor(
    private testNamesService : TestsService,
    private route: ActivatedRoute,
    private fb: FormBuilder,
  ) {}

  ngOnInit() {
    if(this.techDirect == null) {
      this.techDirect = 0;
    }
    this.testNamesService.getAll(this.groupId, this.techDirect).subscribe(data => {
      console.log(data);
      this.tests = data;
      this.testRows = [];
      this.removedTests = [];
      this.testToSave = [];
      TestsNamesComponent.counter = this.tests.length;
      if (TestsNamesComponent.counter<=0){
        this.createDefaultTests();
      }
      else {
        for (let i = 0; i < this.tests.length; i++) {
          let test = new Tests('',0);
          test.setTestRows(this.tests[i]);
          this.testRows.push({key : i+1, value : test});
        }
      }
    });
  }

  save() {
    if(this.isFormValid()){
      this.removedTests.forEach(test=>{
        this.testToSave.push(test);
      });
      this.testRows.forEach(obj=>{
          console.log(obj+"saving test forech ===");
          this.testToSave.push(obj.value);

      });
      this.testNamesService.addTests(this.testToSave, this.groupId).subscribe(() => {
        this.tests = [];
        this.ngOnInit();
      });
      this.studRef.setTests(this.testToSave);
    }
    else{
      this.displayValidationDialog = true;
    }
  }

  isFormValid(): boolean {
    for(let i=0;i<this.testRows.length;i++)
    {
      if(this.testRows[i].value.testName.length >= 50 || this.testRows[i].value.testName == null){
        console.log("wrong data entered");
        return false;
      }
      if(this.testRows[i].value.testMaxScore>1000 || this.testRows[i].value.testMaxScore<0
        || this.testRows[i].value.testMaxScore==null){
        console.log("wrong data entered");
        return false;
      }
    }
    console.log("true value");
    return true;
  }

  add() {
    if(TestsNamesComponent.counter>=Constants.MaxValueOfTests) {
      return;
    }
    else {
      var testNum = ++TestsNamesComponent.counter;
      let test : Tests = new Tests((Constants.DefaultTestName+(testNum)),Constants.DefaultPoint);

      var keys = this.testRows.map(function(o) { return o.key; });
      for(let i=1; i<=10;i++){
        if(keys.indexOf(i)>-1){
          continue;
        }
        else {
          this.testRows.push({key: i, value: test});
          break;
        }
      }
    }
  }

  removeTest() {
    TestsNamesComponent.counter--;
      let test = new Tests('',0);
      let index = this.tests.indexOf(this.currTest);
      this.currTest.removed = true;
      test.setTestRows(this.currTest);
      this.removedTests.push(test);
      this.testRows.splice(this.currIndex,1);
      this.displayRemoveDialog = false;
  }


  removeDialog (index : number, test : any) {
      this.displayRemoveDialog = true;
      this.currIndex = index;
      this.currTest = new Tests('',0);
      this.currTest.setTestRows(test);
  }

  cancelRemovingClick() {
    this.displayRemoveDialog = false;
  }

  okAndCLose() {
    this.displayValidationDialog = false;
  }

  cancelChanges() {
    this.testRows = [];
    this.removedTests = [];

    TestsNamesComponent.counter = this.tests.length;
    if (TestsNamesComponent.counter <= 0) {
      this.createDefaultTests();
    }
    else {
      for (let i = 0; i < this.tests.length; i++) {
        let test = new Tests('',0);
        test.setTestRows(this.tests[i]);
        this.testRows.push({key : i+1, value : test});
      }
    }
  }

  createDefaultTests(){
    for(let i=0;i<5;i++) {
      this.add();
    }
  }

  updateTab(){
    this.ngOnInit();
  }

  getTestsTemplate(directionId:number) {
    this.tests = [];
    this.testNamesService.getTestTemplates(directionId).subscribe(data => {
      console.log(data);
      this.tests = data;

      TestsNamesComponent.counter = this.tests.length;
    });
  }
}

