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
  displayedColumns = ['testName','testMaxScore','testId'];
  dataSource : MatTableDataSource<Tests>;
  // @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private testNamesService : TestsService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.groupId = +this.route.snapshot.paramMap.get('id');
    this.testNamesService.getAll(this.groupId).subscribe(data => {
      console.log(data)
      this.tests = data
      this.dataSource = new MatTableDataSource<Tests>(data)
    });
  }

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
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

 const TestMock : Tests[] = [{
  testId : 222,
  groupId : 586,
  // testName: ['test1', 'test2', 'test3', 'test4', 'test5', 'test6' ,'test7', 'test8', 'test9', 'test10'],
  // max_point: [11, 12, 13, 14, 15, 16, 17, 18, 19, 10]
  testName: 'test1',
  testMaxScore: 11
}];
