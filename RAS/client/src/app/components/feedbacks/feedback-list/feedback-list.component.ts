import { Component, OnInit } from '@angular/core';
import {Student} from "../../../models/student";
import {FeedbackService} from "../../../services/feedbacks/feedback.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-feedback-list',
  templateUrl: './feedback-list.component.html',
  styleUrls: ['./feedback-list.component.css']
})
export class FeedbackListComponent implements OnInit {
  students: Student[];

  constructor(
    // private feedbackService: FeedbackService,
    //           private router: Router,
    //           private route: ActivatedRoute
  ) { }

  ngOnInit() {
    // this.feedbackService.getAllStudent().subscribe(
    //   data => {
    //     this.students = data;
    //   },
    //   error => console.log(error)
    // );
  }

}
