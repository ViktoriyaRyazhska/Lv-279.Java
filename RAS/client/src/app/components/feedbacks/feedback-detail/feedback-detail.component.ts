import {Component, OnInit} from '@angular/core';
import {Student} from "../../../models/student";
import {FeedbackService} from "../../../services/feedbacks/feedback.service";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-feedback-detail',
  templateUrl: './feedback-detail.component.html',
  styleUrls: ['./feedback-detail.component.css']
})
export class FeedbackDetailComponent implements OnInit {
  student: Student;
  id: number;

  constructor(private feedbackService: FeedbackService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params
      .subscribe(
        (params: Params) => {
          this.id = +params['id'];
          this.student = this.feedbackService.getStudent(this.id);
        }
      )
  }
}
