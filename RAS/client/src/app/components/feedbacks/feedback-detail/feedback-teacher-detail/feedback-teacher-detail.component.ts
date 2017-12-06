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
  learningAbility: string;
  one: number = 1;
  marks: Array<any>;
  markValue: any;

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

  onChoose() {
    console.log(this.markValue);
    for (let mark of this.marks) {
      console.log(mark.name == this.markValue);
      if (mark.name == this.markValue) {
        this.learningAbility = mark.description;
      }
    }
  }

  // onSave(){
  //       console.log(this.markValue)
  // }
}
