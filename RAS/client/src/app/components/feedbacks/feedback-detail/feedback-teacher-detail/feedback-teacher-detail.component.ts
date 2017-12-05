import {Component, OnInit} from '@angular/core';
import {FeedbackDetailService} from "../feedback-detail.service";
import {Mark} from "../mark.model";

@Component({
  selector: 'app-feedback-teacher-detail',
  templateUrl: './feedback-teacher-detail.component.html',
  styleUrls: ['./feedback-teacher-detail.component.css'],
  providers: [FeedbackDetailService]
})
export class FeedbackTeacherDetailComponent implements OnInit {
  one: number = 1;
  marks: Array<any>;
  desc: any;

  constructor(private feedbackDetailService: FeedbackDetailService) {
  }

  ngOnInit() {
    this.feedbackDetailService.getAllMarks().subscribe(
      data => {
        this.marks = data;
      },
      error => console.log(error)
    );
  }

  onSave(){
        console.log(this.desc)
  }
}
