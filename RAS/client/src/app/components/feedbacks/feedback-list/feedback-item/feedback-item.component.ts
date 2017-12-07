import {Component, Input, OnInit} from '@angular/core';
import {Student} from "../../../../models/student";

@Component({
  selector: 'app-feedback-item',
  templateUrl: './feedback-item.component.html',
  styleUrls: ['./feedback-item.component.css']
})
export class FeedbackItemComponent implements OnInit {
  @Input() student: Student;
  @Input() index: number;

  constructor() { }

  ngOnInit() {
  }

}
