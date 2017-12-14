import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {StudentFeedback, Data, Feedback} from "../../../models/feedbacks/student.model";
import {FormControl, FormGroup} from "@angular/forms";
import {Mark} from "../../../models/feedbacks/mark.model";
import {MarkService} from "../../../services/feedbacks/marks.service";
import {StudentsService} from "../../../services/students/students.service";

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

  private academyId: number = 586;

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

  constructor(private markService: MarkService,
              private studentsService: StudentsService,
              private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.academyId = this.route.snapshot.params['id'];

    this.markService.getAllMarks().subscribe(
      data => {
        this.marks = data;

      },
      error => console.log(error)
    );

    this.studentsService.getAll(this.academyId).subscribe(
      data => {
        this.students = data;
        console.log(this.students);
        this.students.forEach(st => st.data = st.data == null ? new Data() : st.data);
        this.students.forEach(st => st.teacherFeedback = st.teacherFeedback == null ? new Feedback() : st.teacherFeedback);
        this.students.forEach(st => st.expertFeedback = st.expertFeedback == null ? new Feedback() : st.expertFeedback);
        console.log(this.students);
        console.log("loaded " + data.length);
      },
      error => console.log(error)
    );

    this.setBaseForms();
  }

  onSave() {
    this.setDataToStudent(this.signupTeacherForm, this.signupExpertForm, this.signupInterForm);
    this.updateStudents.push(this.selectedStudent);
    console.log(this.selectedStudent);
    this.studentsService.update(this.updateStudents)
      .subscribe(() => {
        this.updateStudents = [];
        this.ngOnInit()
      });
    console.log(this.selectedStudent);
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
  }

  onOverallClick(student: StudentFeedback) {
    this.selectedStudent = student;
    this.displayOverallFeedback = true;
  }

  onProvideClick(student: StudentFeedback) {
    this.selectedStudent = student;
    this.displayProvideFeedback = true;

    this.displayTeacherFeedback = true;
    this.displayExpertFeedback = false;
    this.displayInterFeedback = false;

    this.setDescValue();
    this.initForms();
  }

  setDataToStudent(teacherForm: FormGroup, expertForm: FormGroup, interForm: FormGroup) {
    if (this.selectedStudent.teacherFeedback != null) {
      this.selectedStudent.teacherFeedback.learningAbility = this.getMark(+teacherForm.get('learningAbilityTeacher').value);
      this.selectedStudent.teacherFeedback.overallTechnicalCompetence = this.getMark(+teacherForm.get('overallTechCompetenceTeacher').value);
      this.selectedStudent.teacherFeedback.passionalInitiative = this.getMark(+teacherForm.get('passionalInitiativeTeacher').value);
      this.selectedStudent.teacherFeedback.teamWork = this.getMark(+teacherForm.get('teamWorkTeacher').value);
      this.selectedStudent.teacherFeedback.gettingThingsDone = this.getMark(+teacherForm.get('getThingsDoneTeacher').value);
      this.selectedStudent.teacherFeedback.activeCommunicator = this.getMark(+teacherForm.get('activeCommunicatorTeacher').value);
      this.selectedStudent.teacherFeedback.summary = teacherForm.get('summaryTeacher').value;
    }
    if (this.selectedStudent.expertFeedback != null) {
      this.selectedStudent.expertFeedback.learningAbility = this.getMark(+expertForm.get('learningAbilityExpert').value);
      this.selectedStudent.expertFeedback.overallTechnicalCompetence = this.getMark(+expertForm.get('overallTechCompetenceExpert').value);
      this.selectedStudent.expertFeedback.passionalInitiative = this.getMark(+expertForm.get('passionalInitiativeExpert').value);
      this.selectedStudent.expertFeedback.teamWork = this.getMark(+expertForm.get('teamWorkExpert').value);
      this.selectedStudent.expertFeedback.gettingThingsDone = this.getMark(+expertForm.get('getThingsDoneExpert').value);
      this.selectedStudent.expertFeedback.activeCommunicator = this.getMark(+expertForm.get('activeCommunicatorExpert').value);
      this.selectedStudent.expertFeedback.summary = expertForm.get('summaryExpert').value;
    }
    if (this.selectedStudent.data != null) {
      this.selectedStudent.data.interviewerComment = interForm.get('summary').value;
    }
  }

  initForms() {
    this.setBaseForms();

    this.initTeacherForm();

    this.initExpertForm();

    this.initInterForm();

    this.descriptionSelector();

    console.log(this.signupTeacherForm);
    console.log(this.signupExpertForm);
    console.log(this.signupInterForm);
  }

  setBaseForms() {
    this.signupTeacherForm = new FormGroup({
      'learningAbilityTeacher': new FormControl(),
      'overallTechCompetenceTeacher': new FormControl(),
      'passionalInitiativeTeacher': new FormControl(),
      'teamWorkTeacher': new FormControl(),
      'getThingsDoneTeacher': new FormControl(),
      'activeCommunicatorTeacher': new FormControl(),
      'summaryTeacher': new FormControl()
    });
    this.signupExpertForm = new FormGroup({
      'learningAbilityExpert': new FormControl(),
      'overallTechCompetenceExpert': new FormControl(),
      'passionalInitiativeExpert': new FormControl(),
      'teamWorkExpert': new FormControl(),
      'getThingsDoneExpert': new FormControl(),
      'activeCommunicatorExpert': new FormControl(),
      'summaryExpert': new FormControl()
    });
    this.signupInterForm = new FormGroup({
      'summary': new FormControl()
    });
  }
  initTeacherForm() {
    if (this.selectedStudent.teacherFeedback.learningAbility != null) {
      this.signupTeacherForm.patchValue({'learningAbilityTeacher': this.selectedStudent.teacherFeedback.learningAbility.id});
    }
    if (this.selectedStudent.teacherFeedback.overallTechnicalCompetence != null) {
      this.signupTeacherForm.patchValue({'overallTechCompetenceTeacher': this.selectedStudent.teacherFeedback.overallTechnicalCompetence.id});
    }
    if (this.selectedStudent.teacherFeedback.passionalInitiative != null) {
      this.signupTeacherForm.patchValue({'passionalInitiativeTeacher': this.selectedStudent.teacherFeedback.passionalInitiative.id});
    }
    if (this.selectedStudent.teacherFeedback.teamWork != null) {
      this.signupTeacherForm.patchValue({'teamWorkTeacher': this.selectedStudent.teacherFeedback.teamWork.id});
    }
    if (this.selectedStudent.teacherFeedback.gettingThingsDone != null) {
      this.signupTeacherForm.patchValue({'getThingsDoneTeacher': this.selectedStudent.teacherFeedback.gettingThingsDone.id});
    }
    if (this.selectedStudent.teacherFeedback.activeCommunicator != null) {
      this.signupTeacherForm.patchValue({'activeCommunicatorTeacher': this.selectedStudent.teacherFeedback.activeCommunicator.id});
    }
    if (this.selectedStudent.teacherFeedback.summary != null) {
      this.signupTeacherForm.patchValue({'activeCommunicatorTeacher': this.selectedStudent.teacherFeedback.summary});
    }
  }

  initExpertForm() {
    console.log(this.signupTeacherForm)
    if (this.selectedStudent.expertFeedback.learningAbility != null) {
      this.signupTeacherForm.patchValue({'learningAbilityExpert': this.selectedStudent.expertFeedback.learningAbility.id});
    }
    if (this.selectedStudent.expertFeedback.overallTechnicalCompetence != null) {
      this.signupTeacherForm.patchValue({'overallTechCompetenceExpert': this.selectedStudent.expertFeedback.overallTechnicalCompetence.id});
    }
    if (this.selectedStudent.expertFeedback.passionalInitiative != null) {
      this.signupTeacherForm.patchValue({'passionalInitiativeExpert': this.selectedStudent.expertFeedback.passionalInitiative.id});
    }
    if (this.selectedStudent.expertFeedback.teamWork != null) {
      this.signupTeacherForm.patchValue({'teamWorkExpert': this.selectedStudent.expertFeedback.teamWork.id});
    }
    if (this.selectedStudent.expertFeedback.gettingThingsDone != null) {
      this.signupTeacherForm.patchValue({'getThingsDoneExpert': this.selectedStudent.expertFeedback.gettingThingsDone.id});
    }
    if (this.selectedStudent.expertFeedback.activeCommunicator != null) {
      this.signupTeacherForm.patchValue({'activeCommunicatorExpert': this.selectedStudent.expertFeedback.activeCommunicator.id});
    }
    if (this.selectedStudent.expertFeedback.summary != null) {
      this.signupTeacherForm.patchValue({'activeCommunicatorExpert': this.selectedStudent.expertFeedback.summary});
    }
  }

  initInterForm() {
    if (this.selectedStudent.data.interviewerComment != null) {
      this.signupInterForm.patchValue({
        'summary': this.selectedStudent.data.interviewerComment
      });
    }
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
        if (this.signupTeacherForm.get('learningAbilityTeacher').value != null && mark.id == this.signupTeacherForm.get('learningAbilityTeacher').value && mark.characteristic.id == this.CharId.ONE) {
          this.learnDescTeacher = mark.description;
        }
        if (this.signupTeacherForm.get('overallTechCompetenceTeacher').value != null && mark.id == this.signupTeacherForm.get('overallTechCompetenceTeacher').value && mark.characteristic.id == this.CharId.TWO) {
          this.overallDescTeacher = mark.description;
        }
        if (this.signupTeacherForm.get('passionalInitiativeTeacher').value != null && mark.id == this.signupTeacherForm.get('passionalInitiativeTeacher').value && mark.characteristic.id == this.CharId.THREE) {
          this.passDescTeacher = mark.description;
        }
        if (this.signupTeacherForm.get('teamWorkTeacher').value != null && mark.id == this.signupTeacherForm.get('teamWorkTeacher').value && mark.characteristic.id == this.CharId.FOUR) {
          this.teamDescTeacher = mark.description;
        }
        if (this.signupTeacherForm.get('getThingsDoneTeacher').value != null && mark.id == this.signupTeacherForm.get('getThingsDoneTeacher').value && mark.characteristic.id == this.CharId.FIVE) {
          this.getDescTeacher = mark.description;
        }
        if (this.signupTeacherForm.get('activeCommunicatorTeacher').value != null && mark.id == this.signupTeacherForm.get('activeCommunicatorTeacher').value && mark.characteristic.id == this.CharId.SIX) {
          this.actDescTeacher = mark.description;
        }
      }
    }
    if (this.marks != null) {
      for (let mark of this.marks) {
        if (this.signupExpertForm.get('learningAbilityExpert').value != null && mark.id == this.signupExpertForm.get('learningAbilityExpert').value && mark.characteristic.id == this.CharId.ONE) {
          this.learnDescExpert = mark.description;
        }
        if (this.signupExpertForm.get('overallTechCompetenceExpert').value != null && mark.id == this.signupExpertForm.get('overallTechCompetenceExpert').value && mark.characteristic.id == this.CharId.TWO) {
          this.overallDescExpert = mark.description;
        }
        if (this.signupExpertForm.get('passionalInitiativeExpert').value != null && mark.id == this.signupExpertForm.get('passionalInitiativeExpert').value && mark.characteristic.id == this.CharId.THREE) {
          this.passDescExpert = mark.description;
        }
        if (this.signupExpertForm.get('teamWorkExpert').value != null && mark.id == this.signupExpertForm.get('teamWorkExpert').value && mark.characteristic.id == this.CharId.FOUR) {
          this.teamDescExpert = mark.description;
        }
        if (this.signupExpertForm.get('getThingsDoneExpert').value != null && mark.id == this.signupExpertForm.get('getThingsDoneExpert').value && mark.characteristic.id == this.CharId.FIVE) {
          this.getDescExpert = mark.description;
        }
        if (this.signupExpertForm.get('activeCommunicatorExpert').value != null && mark.id == this.signupExpertForm.get('activeCommunicatorExpert').value && mark.characteristic.id == this.CharId.SIX) {
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
