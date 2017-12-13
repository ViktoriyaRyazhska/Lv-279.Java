import {Component, OnInit} from '@angular/core';
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
  private CharId: any = Object.assign({}, CharacteristicId);

  private signupTeacherForm: FormGroup;
  private signupExpertForm: FormGroup;
  private signupInterForm: FormGroup;

  private students: StudentFeedback[];
  private updateStudents: StudentFeedback[] = [];
  private selectedStudent: StudentFeedback;
  private marks: Array<Mark>;

  private displayStudentDetails: boolean;
  private displayOverallFeedback: boolean;
  private displayProvideFeedback: boolean;
  private displayTeacherFeedback: boolean;
  private displayExpertFeedback: boolean;
  private displayInterFeedback: boolean;

  private learnDesc: string;
  private overallDesc: string;
  private passDesc: string;
  private teamDesc: string;
  private getDesc: string;
  private actDesc: string;
  //TODO


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

    this.signupTeacherForm = new FormGroup({
      'learningAbility': new FormControl(),
      'overallTechCompetence': new FormControl(),
      'passionalInitiative': new FormControl(),
      'teamWork': new FormControl(),
      'getThingsDone': new FormControl(),
      'activeCommunicator': new FormControl(),
      'summary': new FormControl()
    });
    this.signupExpertForm = new FormGroup({
      'learningAbility': new FormControl(),
      'overallTechCompetence': new FormControl(),
      'passionalInitiative': new FormControl(),
      'teamWork': new FormControl(),
      'getThingsDone': new FormControl(),
      'activeCommunicator': new FormControl(),
      'summary': new FormControl()
    });
    this.signupInterForm = new FormGroup({
      'summary': new FormControl()
    });

    console.log(this.students)
  }

  onSave() {
    this.setDataToStudent(this.signupTeacherForm, this.signupExpertForm, this.signupInterForm);
    this.updateStudents.push(this.selectedStudent);
    this.feedbackService.updateStudents(this.updateStudents);

    this.updateStudents = [];
    this.displayProvideFeedback = false;
  }

  onStudentClick(student: StudentFeedback) {
    this.selectedStudent = student;
    this.displayStudentDetails = true;
  }

  onClickTeacher() {
    this.displayTeacherFeedback = true;
    this.displayExpertFeedback = false;
    this.displayInterFeedback = false;
    this.onChangeTab();
  }

  onClickExpert() {
    this.displayTeacherFeedback = false;
    this.displayExpertFeedback = true;
    this.displayInterFeedback = false;
    this.onChangeTab();
  }

  onClickInterviewer() {
    this.displayTeacherFeedback = false;
    this.displayExpertFeedback = false;
    this.displayInterFeedback = true;
    this.onChangeTab();
  }

  onChangeTab() {
    this.setDataToStudent(this.signupTeacherForm, this.signupExpertForm, this.signupInterForm);
    this.updateStudents.push(this.selectedStudent);
    this.feedbackService.updateStudents(this.updateStudents);
    this.updateStudents = [];
  }

  onOverallClick(student: StudentFeedback) {
    this.selectedStudent = student;
    this.displayOverallFeedback = true;
  }

  onProvideClick(student: StudentFeedback) {
    this.selectedStudent = null;
    this.selectedStudent = student;
    this.displayProvideFeedback = true;
    this.displayTeacherFeedback = true;

    if (this.selectedStudent.teacherFeedback.learningAbility != null) {
      this.signupTeacherForm.setValue({
        'learningAbility': this.selectedStudent.teacherFeedback.learningAbility.id,
        'overallTechCompetence': this.selectedStudent.teacherFeedback.overallTechnicalCompetence.id,
        'passionalInitiative': this.selectedStudent.teacherFeedback.passionalInitiative.id,
        'teamWork': this.selectedStudent.teacherFeedback.teamWork.id,
        'getThingsDone': this.selectedStudent.teacherFeedback.gettingThingsDone.id,
        'activeCommunicator': this.selectedStudent.teacherFeedback.activeCommunicator.id,
        'summary': this.selectedStudent.teacherFeedback.summary
      });

      this.onChoose();
    }
    if (this.selectedStudent.expertFeedback.learningAbility != null) {
      this.signupExpertForm.setValue({
        'learningAbility': this.selectedStudent.expertFeedback.learningAbility.id,
        'overallTechCompetence': this.selectedStudent.expertFeedback.overallTechnicalCompetence.id,
        'passionalInitiative': this.selectedStudent.expertFeedback.passionalInitiative.id,
        'teamWork': this.selectedStudent.expertFeedback.teamWork.id,
        'getThingsDone': this.selectedStudent.expertFeedback.gettingThingsDone.id,
        'activeCommunicator': this.selectedStudent.expertFeedback.activeCommunicator.id,
        'summary': this.selectedStudent.expertFeedback.summary
      });

      this.onChoose();
    }
    if (this.selectedStudent.data != null) {
      this.signupInterForm.setValue({
        'summary': this.selectedStudent.data.interviewerComment
      });
    }

    console.log(this.signupTeacherForm);
    console.log(this.signupExpertForm);
    console.log(this.signupInterForm);
  }

  setDataToStudent(teacherForm: FormGroup, expertForm: FormGroup, interForm: FormGroup) {
    if (this.selectedStudent.teacherFeedback != null) {
      this.selectedStudent.teacherFeedback.learningAbility = this.getMark(+teacherForm.get('learningAbility').value);
      this.selectedStudent.teacherFeedback.overallTechnicalCompetence = this.getMark(+teacherForm.get('overallTechCompetence').value);
      this.selectedStudent.teacherFeedback.passionalInitiative = this.getMark(+teacherForm.get('passionalInitiative').value);
      this.selectedStudent.teacherFeedback.teamWork = this.getMark(+teacherForm.get('teamWork').value);
      this.selectedStudent.teacherFeedback.gettingThingsDone = this.getMark(+teacherForm.get('getThingsDone').value);
      this.selectedStudent.teacherFeedback.activeCommunicator = this.getMark(+teacherForm.get('activeCommunicator').value);
      this.selectedStudent.teacherFeedback.summary = teacherForm.get('summary').value;
    }
    if (this.selectedStudent.expertFeedback != null) {
      this.selectedStudent.expertFeedback.learningAbility = this.getMark(+expertForm.get('learningAbility').value);
      this.selectedStudent.expertFeedback.overallTechnicalCompetence = this.getMark(+expertForm.get('overallTechCompetence').value);
      this.selectedStudent.expertFeedback.passionalInitiative = this.getMark(+expertForm.get('passionalInitiative').value);
      this.selectedStudent.expertFeedback.teamWork = this.getMark(+expertForm.get('teamWork').value);
      this.selectedStudent.expertFeedback.gettingThingsDone = this.getMark(+expertForm.get('getThingsDone').value);
      this.selectedStudent.expertFeedback.activeCommunicator = this.getMark(+expertForm.get('activeCommunicator').value);
      this.selectedStudent.expertFeedback.summary = expertForm.get('summary').value;
    }
    if (this.selectedStudent.data != null) {
      this.selectedStudent.data.interviewerComment = interForm.get('summary').value;
    }
  }

  onChoose() {
    //TODO
    if (this.marks != null) {
      for (let mark of this.marks) {
        if (mark.id == this.signupTeacherForm.get('learningAbility').value && mark.characteristic.id == this.CharId.ONE) {
          this.learnDesc = mark.description;
        }
        if (mark.id == this.signupTeacherForm.get('overallTechCompetence').value && mark.characteristic.id == this.CharId.TWO) {
          this.overallDesc = mark.description;
        }
        if (mark.id == this.signupTeacherForm.get('passionalInitiative').value && mark.characteristic.id == this.CharId.THREE) {
          this.passDesc = mark.description;
        }
        if (mark.id == this.signupTeacherForm.get('teamWork').value && mark.characteristic.id == this.CharId.FOUR) {
          this.teamDesc = mark.description;
        }
        if (mark.id == this.signupTeacherForm.get('getThingsDone').value && mark.characteristic.id == this.CharId.FIVE) {
          this.getDesc = mark.description;
        }
        if (mark.id == this.signupTeacherForm.get('activeCommunicator').value && mark.characteristic.id == this.CharId.SIX) {
          this.actDesc = mark.description;
        }
      }
    }
  }

  getMark(id: number): Mark {
    if (this.marks != null) {
      for (let mark of this.marks) {
        if (mark.id == id) {
          return mark;
        }
      }
    }
    return null;
  }

}
