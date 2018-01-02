import {Component, Injectable, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {StudentFeedback, Data, Feedback} from "../../../models/feedbacks/student.model";
import {FormControl, FormGroup} from "@angular/forms";
import {Mark} from "../../../models/feedbacks/mark.model";
import {MarkService} from "../../../services/feedbacks/marks.service";
import {StudentsService} from "../../../services/students/students.service";
import {LoginService} from "../../auth/login/login.service";
import {Authority} from "../../auth/Authority";

export enum CharacteristicId {
  ZERO = 0,
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
@Injectable()
export class FeedbackListComponent implements OnInit {
  @Input() groupId: number;

  private CharId: any = Object.assign({}, CharacteristicId);

  private academyId: number;

  private signupFeedbackForm: FormGroup;

  private students: StudentFeedback[];
  private selectedStudent: StudentFeedback;
  private updateStudent: StudentFeedback;

  private marks: Mark[];

  private displayStudentDetails: boolean;
  private displayOverallFeedback: boolean;
  private displayProvideFeedback: boolean;

  private disabledPreviousButton: boolean;
  private disabledNextButton: boolean;

  private learnDescTeacher: string;
  private overallDescTeacher: string;
  private passDescTeacher: string;
  private teamDescTeacher: string;
  private getDescTeacher: string;
  private actDescTeacher: string;

  private learnDescExpert: string;
  private overallDescExpert: string;
  private passDescExpert: string;
  private teamDescExpert: string;
  private getDescExpert: string;
  private actDescExpert: string;
  private isAssignedAsTeacher:boolean;
  private isAssignedAsExpert:boolean;
  private isAssignedAsInterviewer:boolean;

  constructor(private markService: MarkService,
              private studentsService: StudentsService,
              private route: ActivatedRoute,
              private router:Router,
              private loginService: LoginService) {
  }

  ngOnInit() {
    this.academyId = this.groupId;

  this.loginService.check1(this.academyId).subscribe(data=>{
    if (data==true && this.loginService.isAuthoryty(Authority.TEACHER)){
      this.isAssignedAsTeacher=true;
    }
    if (data==true && this.loginService.isAuthoryty(Authority.EXPERT)){
      this.isAssignedAsExpert=true;
    }
    if (data==true && this.loginService.isAuthoryty(Authority.INTERVIEWER)){
      this.isAssignedAsInterviewer=true;
    }
  });

    this.markService.getAllMarks().subscribe(
      data => {
        this.marks = data;
      },
      error => {
        if (error.status===403) {
          this.router.navigate(['ang/error']);
        }
        console.log(error)
      }
    );

    this.studentsService.getAll(this.academyId).subscribe(
      data => {
        this.students = data;
        this.students.forEach(st => st.data = st.data == null ? new Data() : st.data);
        this.students.forEach(st => st.teacherFeedback = st.teacherFeedback == null ? new Feedback() : st.teacherFeedback);
        this.students.forEach(st => st.expertFeedback = st.expertFeedback == null ? new Feedback() : st.expertFeedback);
        console.log(this.students);
      },
      error => console.log(error)
    );

    this.setBaseForms();
  }

  saveStudent(){
    this.setDataToStudent(this.signupFeedbackForm);
    this.updateStudent = this.selectedStudent;

    this.studentsService.updateStudent(this.updateStudent)
      .subscribe(error => (
        console.log(error)
      ));
    console.log(this.selectedStudent);
    this.updateStudent = null;
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
    this.disabledPreviousButton = false;
    this.disabledNextButton = false;

    if(this.findStudentIndex(student) == this.CharId.ZERO){
      this.disabledPreviousButton = true;
    }
    if(this.findStudentIndex(student) == this.students.length - this.CharId.ONE){
      this.disabledNextButton = true;
    }
    this.selectedStudent = student;
    this.displayProvideFeedback = true;
    this.initForms();
  }

  onSaveClose() {
    this.setDataToStudent(this.signupFeedbackForm);
    this.updateStudent = this.selectedStudent;

    this.studentsService.updateStudent(this.updateStudent)
      .subscribe(() => {
          this.students = null;
          this.ngOnInit();
        },
        error => (
          console.log(error)
        ));
    this.updateStudent = null;
    this.displayProvideFeedback = false;
  }

  onPreviousSave(student: StudentFeedback){
    this.disabledNextButton = false;

    this.saveStudent();
    if((this.findStudentIndex(student) - this.CharId.ONE) != this.CharId.ZERO){
      this.selectedStudent = this.students[this.findStudentIndex(student) - this.CharId.ONE];
      this.initForms();
    } else {
      this.selectedStudent = this.students[this.findStudentIndex(student) - this.CharId.ONE];
      this.disabledPreviousButton = true;
      this.initForms();
    }
  }

  onNextSave(student: StudentFeedback) {
    this.disabledPreviousButton = false;

    this.saveStudent();
    if((this.findStudentIndex(student) + this.CharId.ONE) != (this.students.length - this.CharId.ONE)) {
      this.selectedStudent = this.students[this.findStudentIndex(student) + this.CharId.ONE];
      this.initForms();
    } else {
      this.selectedStudent = this.students[this.findStudentIndex(student) + this.CharId.ONE];
      this.disabledNextButton = true;
      this.initForms();
    }
  }

  findStudentIndex (student: StudentFeedback) : number {
    if(this.students != null && this.students.indexOf(student) != -1) {
      return this.students.indexOf(student)
    }
  }

  initForms() {
    this.setDescValue();

    this.setBaseForms();

    this.initFeedbackForm();

    this.descriptionSelector();
  }

  setDataToStudent(feedbackForm: FormGroup) {
    if (this.selectedStudent.teacherFeedback != null) {
      this.selectedStudent.teacherFeedback.learningAbility = this.getMark(+feedbackForm.get('learningAbilityTeacher').value);
      this.selectedStudent.teacherFeedback.overallTechnicalCompetence = this.getMark(+feedbackForm.get('overallTechCompetenceTeacher').value);
      this.selectedStudent.teacherFeedback.passionalInitiative = this.getMark(+feedbackForm.get('passionalInitiativeTeacher').value);
      this.selectedStudent.teacherFeedback.teamWork = this.getMark(+feedbackForm.get('teamWorkTeacher').value);
      this.selectedStudent.teacherFeedback.gettingThingsDone = this.getMark(+feedbackForm.get('getThingsDoneTeacher').value);
      this.selectedStudent.teacherFeedback.activeCommunicator = this.getMark(+feedbackForm.get('activeCommunicatorTeacher').value);
      this.selectedStudent.teacherFeedback.summary = feedbackForm.get('summaryTeacher').value;
    }
    if (this.selectedStudent.expertFeedback != null) {
      this.selectedStudent.expertFeedback.learningAbility = this.getMark(+feedbackForm.get('learningAbilityExpert').value);
      this.selectedStudent.expertFeedback.overallTechnicalCompetence = this.getMark(+feedbackForm.get('overallTechCompetenceExpert').value);
      this.selectedStudent.expertFeedback.passionalInitiative = this.getMark(+feedbackForm.get('passionalInitiativeExpert').value);
      this.selectedStudent.expertFeedback.teamWork = this.getMark(+feedbackForm.get('teamWorkExpert').value);
      this.selectedStudent.expertFeedback.gettingThingsDone = this.getMark(+feedbackForm.get('getThingsDoneExpert').value);
      this.selectedStudent.expertFeedback.activeCommunicator = this.getMark(+feedbackForm.get('activeCommunicatorExpert').value);
      this.selectedStudent.expertFeedback.summary = feedbackForm.get('summaryExpert').value;
    }
    if (this.selectedStudent.data != null) {
      this.selectedStudent.data.interviewerComment = feedbackForm.get('summary').value;
    }
  }

  initFeedbackForm() {
    if (this.selectedStudent.teacherFeedback.learningAbility != null) {
      this.signupFeedbackForm.patchValue({'learningAbilityTeacher': this.selectedStudent.teacherFeedback.learningAbility.id});
    }
    if (this.selectedStudent.teacherFeedback.overallTechnicalCompetence != null) {
      this.signupFeedbackForm.patchValue({'overallTechCompetenceTeacher': this.selectedStudent.teacherFeedback.overallTechnicalCompetence.id});
    }
    if (this.selectedStudent.teacherFeedback.passionalInitiative != null) {
      this.signupFeedbackForm.patchValue({'passionalInitiativeTeacher': this.selectedStudent.teacherFeedback.passionalInitiative.id});
    }
    if (this.selectedStudent.teacherFeedback.teamWork != null) {
      this.signupFeedbackForm.patchValue({'teamWorkTeacher': this.selectedStudent.teacherFeedback.teamWork.id});
    }
    if (this.selectedStudent.teacherFeedback.gettingThingsDone != null) {
      this.signupFeedbackForm.patchValue({'getThingsDoneTeacher': this.selectedStudent.teacherFeedback.gettingThingsDone.id});
    }
    if (this.selectedStudent.teacherFeedback.activeCommunicator != null) {
      this.signupFeedbackForm.patchValue({'activeCommunicatorTeacher': this.selectedStudent.teacherFeedback.activeCommunicator.id});
    }
    if (this.selectedStudent.teacherFeedback.summary != null) {
      this.signupFeedbackForm.patchValue({'summaryTeacher': this.selectedStudent.teacherFeedback.summary});
    }
    if (this.selectedStudent.expertFeedback.learningAbility != null) {
      this.signupFeedbackForm.patchValue({'learningAbilityExpert': this.selectedStudent.expertFeedback.learningAbility.id});
    }
    if (this.selectedStudent.expertFeedback.overallTechnicalCompetence != null) {
      this.signupFeedbackForm.patchValue({'overallTechCompetenceExpert': this.selectedStudent.expertFeedback.overallTechnicalCompetence.id});
    }
    if (this.selectedStudent.expertFeedback.passionalInitiative != null) {
      this.signupFeedbackForm.patchValue({'passionalInitiativeExpert': this.selectedStudent.expertFeedback.passionalInitiative.id});
    }
    if (this.selectedStudent.expertFeedback.teamWork != null) {
      this.signupFeedbackForm.patchValue({'teamWorkExpert': this.selectedStudent.expertFeedback.teamWork.id});
    }
    if (this.selectedStudent.expertFeedback.gettingThingsDone != null) {
      this.signupFeedbackForm.patchValue({'getThingsDoneExpert': this.selectedStudent.expertFeedback.gettingThingsDone.id});
    }
    if (this.selectedStudent.expertFeedback.activeCommunicator != null) {
      this.signupFeedbackForm.patchValue({'activeCommunicatorExpert': this.selectedStudent.expertFeedback.activeCommunicator.id});
    }
    if (this.selectedStudent.expertFeedback.summary != null) {
      this.signupFeedbackForm.patchValue({'summaryExpert': this.selectedStudent.expertFeedback.summary});
    }
    if (this.selectedStudent.data.interviewerComment != null) {
      this.signupFeedbackForm.patchValue({'summary': this.selectedStudent.data.interviewerComment});
    }
  }

  setBaseForms() {
    this.signupFeedbackForm = new FormGroup({
      'learningAbilityTeacher': new FormControl(),
      'overallTechCompetenceTeacher': new FormControl(),
      'passionalInitiativeTeacher': new FormControl(),
      'teamWorkTeacher': new FormControl(),
      'getThingsDoneTeacher': new FormControl(),
      'activeCommunicatorTeacher': new FormControl(),
      'summaryTeacher': new FormControl(),
      'learningAbilityExpert': new FormControl(),
      'overallTechCompetenceExpert': new FormControl(),
      'passionalInitiativeExpert': new FormControl(),
      'teamWorkExpert': new FormControl(),
      'getThingsDoneExpert': new FormControl(),
      'activeCommunicatorExpert': new FormControl(),
      'summaryExpert': new FormControl(),
      'summary': new FormControl()
    });
  }

  setDescValue() {
    this.learnDescTeacher = null;
    this.overallDescTeacher = null;
    this.passDescTeacher = null;
    this.teamDescTeacher = null;
    this.getDescTeacher = null;
    this.actDescTeacher = null;

    this.learnDescExpert = null;
    this.overallDescExpert = null;
    this.passDescExpert = null;
    this.teamDescExpert = null;
    this.getDescExpert = null;
    this.actDescExpert = null;
  }

  onChoose() {
    this.descriptionSelector();
  }

  descriptionSelector() {
    if (this.marks != null) {
      for (let mark of this.marks) {
        if (this.signupFeedbackForm.get('learningAbilityTeacher').value != null && mark.id == this.signupFeedbackForm.get('learningAbilityTeacher').value && mark.characteristic.id == this.CharId.ONE) {
          this.learnDescTeacher = mark.description;
        }
        if (this.signupFeedbackForm.get('overallTechCompetenceTeacher').value != null && mark.id == this.signupFeedbackForm.get('overallTechCompetenceTeacher').value && mark.characteristic.id == this.CharId.TWO) {
          this.overallDescTeacher = mark.description;
        }
        if (this.signupFeedbackForm.get('passionalInitiativeTeacher').value != null && mark.id == this.signupFeedbackForm.get('passionalInitiativeTeacher').value && mark.characteristic.id == this.CharId.THREE) {
          this.passDescTeacher = mark.description;
        }
        if (this.signupFeedbackForm.get('teamWorkTeacher').value != null && mark.id == this.signupFeedbackForm.get('teamWorkTeacher').value && mark.characteristic.id == this.CharId.FOUR) {
          this.teamDescTeacher = mark.description;
        }
        if (this.signupFeedbackForm.get('getThingsDoneTeacher').value != null && mark.id == this.signupFeedbackForm.get('getThingsDoneTeacher').value && mark.characteristic.id == this.CharId.FIVE) {
          this.getDescTeacher = mark.description;
        }
        if (this.signupFeedbackForm.get('activeCommunicatorTeacher').value != null && mark.id == this.signupFeedbackForm.get('activeCommunicatorTeacher').value && mark.characteristic.id == this.CharId.SIX) {
          this.actDescTeacher = mark.description;
        }
      }
    }
    if (this.marks != null) {
      for (let mark of this.marks) {
        if (this.signupFeedbackForm.get('learningAbilityExpert').value != null && mark.id == this.signupFeedbackForm.get('learningAbilityExpert').value && mark.characteristic.id == this.CharId.ONE) {
          this.learnDescExpert = mark.description;
        }
        if (this.signupFeedbackForm.get('overallTechCompetenceExpert').value != null && mark.id == this.signupFeedbackForm.get('overallTechCompetenceExpert').value && mark.characteristic.id == this.CharId.TWO) {
          this.overallDescExpert = mark.description;
        }
        if (this.signupFeedbackForm.get('passionalInitiativeExpert').value != null && mark.id == this.signupFeedbackForm.get('passionalInitiativeExpert').value && mark.characteristic.id == this.CharId.THREE) {
          this.passDescExpert = mark.description;
        }
        if (this.signupFeedbackForm.get('teamWorkExpert').value != null && mark.id == this.signupFeedbackForm.get('teamWorkExpert').value && mark.characteristic.id == this.CharId.FOUR) {
          this.teamDescExpert = mark.description;
        }
        if (this.signupFeedbackForm.get('getThingsDoneExpert').value != null && mark.id == this.signupFeedbackForm.get('getThingsDoneExpert').value && mark.characteristic.id == this.CharId.FIVE) {
          this.getDescExpert = mark.description;
        }
        if (this.signupFeedbackForm.get('activeCommunicatorExpert').value != null && mark.id == this.signupFeedbackForm.get('activeCommunicatorExpert').value && mark.characteristic.id == this.CharId.SIX) {
          this.actDescExpert = mark.description;
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
