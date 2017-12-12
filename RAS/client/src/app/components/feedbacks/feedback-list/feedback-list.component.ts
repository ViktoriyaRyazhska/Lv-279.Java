import {Component, OnInit} from '@angular/core';
import {Student} from "../../../models/student";
import {FeedbackService} from "../../../services/feedbacks/feedback.service";
import {ActivatedRoute, Router} from "@angular/router";
import {StudentFeedback} from "../../../models/feedbacks/student.model";
import {FormControl, FormGroup} from "@angular/forms";
import {Mark} from "../../../models/feedbacks/mark.model";
import {MarkService} from "../../../services/feedbacks/marks.service";

export enum CharacteristicId {
  ONE = 1,
  TWO = 2,
  THREE = 3,
  FOUR = 4,
  FIVE = 5,
  SIX = 6
}

@Component({
  selector: 'app-feedback-list',
  templateUrl: './feedback-list.component.html',
  styleUrls: ['./feedback-list.component.css']
})
export class FeedbackListComponent implements OnInit {
  students: StudentFeedback[];
  private selectedStudent: StudentFeedback;

  private CharId: any = Object.assign({}, CharacteristicId);
  private signupForm: FormGroup;
  private marks: Array<Mark>;

  private displayStudentDetails: boolean;
  private displayOverallFeedback: boolean;
  private displayProvideFeedback: boolean;

  learnDesc: string;
  overallDesc: string;
  passDesc: string;
  teamDesc: string;
  getDesc: string;
  actDesc: string;

  constructor(private markService: MarkService,
              private feedbackService: FeedbackService,
              private router: Router,
              private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.markService.getAllMarks().subscribe(
      data => {
        this.marks = data;

      },
      error => console.log(error)
    );

    this.feedbackService.getAllStudent().subscribe(
      data => {
        this.students = data;
      },
      error => console.log(error)
    );

    this.signupForm = new FormGroup({
      'learningAbility': new FormControl(),
      'overallTechCompetence': new FormControl(),
      'passionalInitiative': new FormControl(),
      'teamWork': new FormControl(),
      'getThingsDone': new FormControl(),
      'activeCommunicator': new FormControl(),
      'summary': new FormControl()
    });
  }

  onSave() {
    console.log(this.selectedStudent);
    console.log(this.signupForm);
    this.setDataToStudent(this.signupForm)
    console.log(this.selectedStudent);
  }

  onStudentClick(student: StudentFeedback) {
    this.selectedStudent = student;
    this.displayStudentDetails = true;
  }

  onOverallClick(student: StudentFeedback) {
    this.selectedStudent = student;
    this.displayOverallFeedback = true;
  }

  onProvideClick(student: StudentFeedback) {
    this.selectedStudent = student;
    this.displayProvideFeedback = true;

    this.signupForm.setValue({
      'learningAbility': this.selectedStudent.teacherFeedback.learningAbility.id,
      'overallTechCompetence': this.selectedStudent.teacherFeedback.overallTechnicalCompetence.id,
      'passionalInitiative': this.selectedStudent.teacherFeedback.passionalInitiative.id,
      'teamWork': this.selectedStudent.teacherFeedback.teamWork.id,
      'getThingsDone':this.selectedStudent.teacherFeedback.gettingThingsDone.id,
      'activeCommunicator':this.selectedStudent.teacherFeedback.activeCommunicator.id,
      'summary':this.selectedStudent.teacherFeedback.summary
    });

    this.onChoose();
    console.log(this.signupForm)
  }


  setDataToStudent(form: FormGroup){
    this.selectedStudent.teacherFeedback.learningAbility = this.getMark(+form.get('learningAbility').value);
    this.selectedStudent.teacherFeedback.overallTechnicalCompetence = this.getMark(+form.get('overallTechCompetence').value);
    this.selectedStudent.teacherFeedback.passionalInitiative = this.getMark(+form.get('passionalInitiative').value);
    this.selectedStudent.teacherFeedback.teamWork = this.getMark(+form.get('teamWork').value);
    this.selectedStudent.teacherFeedback.gettingThingsDone = this.getMark(+form.get('getThingsDone').value);
    this.selectedStudent.teacherFeedback.activeCommunicator = this.getMark(+form.get('getThingsDone').value);
    this.selectedStudent.teacherFeedback.summary = form.get('summary').value;
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

}
