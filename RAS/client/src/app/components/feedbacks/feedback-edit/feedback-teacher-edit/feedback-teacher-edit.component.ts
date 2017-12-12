import {Component, OnInit} from '@angular/core';
import {MarkService} from "../../../../services/feedbacks/marks.service";
import {Mark} from "../../../../models/feedbacks/mark.model";
import {FormControl, FormGroup} from "@angular/forms";
import {StudentFeedback} from "../../../../models/feedbacks/student.model";
import {FeedbackService} from "../../../../services/feedbacks/feedback.service";

export enum CharacteristicId {
  ONE = 1,
  TWO = 2,
  THREE = 3,
  FOUR = 4,
  FIVE = 5,
  SIX = 6
}

@Component({
  selector: 'app-feedback-teacher-edit',
  templateUrl: './feedback-teacher-edit.component.html',
  styleUrls: ['./feedback-teacher-edit.component.css'],
  providers: [MarkService]
})
export class FeedbackTeacherEditComponent implements OnInit {
  private CharId: any = Object.assign({}, CharacteristicId);
  private signupForm: FormGroup;

  private marks: Array<Mark>;
  private student: StudentFeedback;

  learnDesc: string;
  overallDesc: string;
  passDesc: string;
  teamDesc: string;
  getDesc: string;
  actDesc: string;

  constructor(private markService: MarkService,
              private feedbackService: FeedbackService) {
    this.markService.getAllMarks().subscribe(
      data => {
        this.marks = data;

      },
      error => console.log(error)
    );
  }

  ngOnInit() {


    this.signupForm = new FormGroup({
      'learningAbility': new FormControl(),
      'overallTechCompetence': new FormControl(),
      'passionalInitiative': new FormControl(),
      'teamWork': new FormControl(),
      'getThingsDone': new FormControl(),
      'activeCommunicator': new FormControl(),
      'summary': new FormControl()
    });

    // this.signupForm.setValue({
    //   'learningAbility': this.student.teacherFeedback.learningAbility.id,
    //   'overallTechCompetence': this.student.teacherFeedback.overallTechnicalCompetence.id,
    //   'passionalInitiative': this.student.teacherFeedback.passionalInitiative.id,
    //   'teamWork': this.student.teacherFeedback.teamWork.id,
    //   'getThingsDone':this.student.teacherFeedback.gettingThingsDone.id,
    //   'activeCommunicator':this.student.teacherFeedback.activeCommunicator.id,
    //   'summary':this.student.teacherFeedback.summary
    // });
    // console.log(this.signupForm)
    this.onChoose();
  }

  onSave() {
    console.log(this.student);
    console.log(this.signupForm);
    // this.setDataToStudent(this.signupForm)
    console.log(this.student);
  }

  // setDataToStudent(form: FormGroup){
  //   this.student.teacherFeedback.learningAbility = this.getMark(+form.get('learningAbility').value);
  //   this.student.teacherFeedback.overallTechnicalCompetence = this.getMark(+form.get('overallTechCompetence').value);
  //   this.student.teacherFeedback.passionalInitiative = this.getMark(+form.get('passionalInitiative').value);
  //   this.student.teacherFeedback.teamWork = this.getMark(+form.get('teamWork').value);
  //   this.student.teacherFeedback.gettingThingsDone = this.getMark(+form.get('getThingsDone').value);
  //   this.student.teacherFeedback.activeCommunicator = this.getMark(+form.get('getThingsDone').value);
  //   this.student.teacherFeedback.summary = form.get('summary').value;
  // }

  getMark(id: number): Mark {
    if(this.marks != null) {
      for (let mark of this.marks) {
        if(mark.id == id) {
          return mark;
        }
      }
    }
    return null;
  }

  onChoose() {
    if (this.marks != null) {
      for (let mark of this.marks) {
        if (mark.id == this.signupForm.get('learningAbility').value && mark.characteristic.id == this.CharId.ONE) {
          this.learnDesc = mark.description;
        }
        if (mark.id == this.signupForm.get('overallTechCompetence').value && mark.characteristic.id == this.CharId.TWO) {
          this.overallDesc = mark.description;
        }
        if (mark.id == this.signupForm.get('passionalInitiative').value && mark.characteristic.id == this.CharId.THREE) {
          this.passDesc = mark.description;
        }
        if (mark.id == this.signupForm.get('teamWork').value && mark.characteristic.id == this.CharId.FOUR) {
          this.teamDesc = mark.description;
        }
        if (mark.id == this.signupForm.get('getThingsDone').value && mark.characteristic.id == this.CharId.FIVE) {
          this.getDesc = mark.description;
        }
        if (mark.id == this.signupForm.get('activeCommunicator').value && mark.characteristic.id == this.CharId.SIX) {
          this.actDesc = mark.description;
        }
      }
    }
  }
}
