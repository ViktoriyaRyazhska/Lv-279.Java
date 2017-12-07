import { Component, OnInit } from '@angular/core';
import {Student} from "../../../../models/student";
import {FeedbackService} from "../../../../services/feedbacks/feedback.service";
import {ActivatedRoute, Params, Router} from "@angular/router";

@Component({
  selector: 'app-feedback-expert-detail',
  templateUrl: './feedback-expert-edit.component.html',
  styleUrls: ['./feedback-expert-edit.component.css']
})
export class FeedbackExpertEditComponent implements OnInit {


  ngOnInit() {
    throw new Error("Method not implemented.");
  }


}
