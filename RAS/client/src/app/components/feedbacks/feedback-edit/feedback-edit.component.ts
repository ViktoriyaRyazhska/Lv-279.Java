import { Component, OnInit } from '@angular/core';
import {Student} from "../../../models/student";
import {FeedbackService} from "../../../services/feedbacks/feedback.service";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-feedback-detail',
  templateUrl: './feedback-edit.component.html',
  styleUrls: ['./feedback-edit.component.css']
})
export class FeedbackEditComponent implements OnInit {
  student: Student;
  id: number;

  constructor(private feedbackService: FeedbackService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {

  }
}
