import { Component, OnInit } from '@angular/core';
import {TestrestService} from '../testrest.service';

@Component({
  selector: 'app-testresp',
  templateUrl: './testresp.component.html',
  styleUrls: ['./testresp.component.css']
})
export class TestrespComponent implements OnInit {
  respStr: String;

  constructor(private testRest: TestrestService) { }

  ngOnInit() {
    this.testRest.getAll().subscribe(
      data => {
        this.respStr = data;
      },
      error => console.log(error)
    );
  }

}
