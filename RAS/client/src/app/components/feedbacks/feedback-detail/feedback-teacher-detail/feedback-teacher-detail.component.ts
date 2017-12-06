import {Component, Input, OnInit, Output} from '@angular/core';
import {FeedbackDetailService} from "../feedback-detail.service";
import {Mark} from "../mark.model";

export enum CharacteristicId {
  ONE = 1,
  TWO = 2,
  THREE = 3,
  FOUR = 4,
  FIVE = 5,
  SIX = 6
}

@Component({
  selector: 'app-feedback-teacher-detail',
  templateUrl: './feedback-teacher-detail.component.html',
  styleUrls: ['./feedback-teacher-detail.component.css'],
  providers: [FeedbackDetailService]
})
export class FeedbackTeacherDetailComponent implements OnInit {
  // @Input() CharacteristicId;
  one:number = CharacteristicId.ONE;
  two:number = CharacteristicId.TWO;
  tree:number = CharacteristicId.THREE;
  four:number = CharacteristicId.FOUR;
  five:number = CharacteristicId.FIVE;
  six:number = CharacteristicId.SIX;

  learnDesc: string;
  overallDesc: string;
  passDesc: string;
  teamDesc: string;
  getDesc: string;
  actDesc: string;

  learnMark: any;
  overallMark: string;
  passMark: string;
  teamMark: string;
  getMark: string;
  actMark: string;

  marks: Array<any>;

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
    for (let mark of this.marks) {
      if (mark.name == this.learnMark && mark.characteristic.id == CharacteristicId.ONE) {
        this.learnDesc = mark.description;
      }
      if (mark.name == this.overallMark && mark.characteristic.id == CharacteristicId.TWO) {
        this.overallDesc = mark.description;
      }
      if (mark.name == this.passMark && mark.characteristic.id == CharacteristicId.THREE) {
        this.passDesc = mark.description;
      }
      if (mark.name == this.teamMark && mark.characteristic.id == CharacteristicId.FOUR) {
        this.teamDesc = mark.description;
      }
      if (mark.name == this.getMark && mark.characteristic.id == CharacteristicId.FIVE) {
        this.getDesc = mark.description;
      }
      if (mark.name == this.actMark && mark.characteristic.id == CharacteristicId.SIX) {
        this.actDesc = mark.description;
      }
    }
  }
}
