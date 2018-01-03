 import {Component, Injectable, OnInit} from '@angular/core';
import 'rxjs/add/operator/map';
import {HistoryService} from "../../history/history.service";
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Group} from "./group.model";
import {ActivatedRoute, Router} from "@angular/router";
import {AddGroupService} from "./add-group.service";
import {MatDialog} from "@angular/material";
import {DialogComponent} from "../dialog/dialog.component";
import {DataService} from "../../../services/data.service";
import {LoginService} from "../../auth/login/login.service";
 import {HistoryListComponent} from "../../history/history-list/history-list.component";
 import {registerLocaleData} from "@angular/common";
 import list from "devextreme/ui/list";

@Component({
  selector: 'app-add-group',
  templateUrl: './add-group.component.html',
  styleUrls: ['./add-group.component.css'],
  providers: [HistoryService]
})

export class AddGroupComponent implements OnInit {
  signupForm: FormGroup;

  group: Group;

  academyStatus: any[];
  city: any[];
  commonDirection: any[];
  direction: any[];
  profile: any[];
  groupId: number;

  invalidForm: boolean = false;

  invalidDate: boolean = false;

  navtab: boolean = false;

  private defaultInvalidInput: string = 'No data entered. Group will not be save';

  paymentStatusArray: {name: string, free: number}[] = [
    {'name': 'Open Group', 'free': 0},
    {'name': 'Founded by SoftServe', 'free': 1}
  ];


  constructor(private addGroupService: AddGroupService,
              private route: ActivatedRoute,
              private router:Router,
              public dialog: MatDialog,
              private loginService: LoginService) {
  }

  ngOnInit() {
    this.group = new Group();
    this.groupId = this.route.snapshot.params['id'];

    this.getDropdownOnInit();

    if(this.router.url.includes('group/update')){
      this.navtab = true;
      this.updateGroup();
    }else if(this.router.url.includes('group/add')) {
      this.formGroupOnInit();
    }
  }

  getDropdownOnInit(){
    this.addGroupService.getDropdownList().subscribe(resp => {
      this.academyStatus = resp.academyStages;
      this.city = resp.cityNames;
      this.commonDirection = resp.direction;
      this.direction = resp.technologie;
      this.profile = resp.profile;
    },error => {
      if (error.status===403) {
        this.router.navigate(['ang/error']);
      }
    });
  }

  formGroupOnInit(){
    this.signupForm = new FormGroup({
      'groupInfoFormControl': new FormControl(this.group.grName, [Validators.required]),
      'nameForSiteFormControl': new FormControl(this.group.nameForSite, [Validators.required]),
      'academyStagesId': new FormControl(this.group.academyStagesId),
      'cityId': new FormControl(this.group.cityId),
      'startDateFormControl': new FormControl(this.group.startDate, [Validators.required]),
      'endDateFormControl': new FormControl(this.group.endDate, [Validators.required]),
      'commonDirectionFormControl': new FormControl(this.group.directionId),
      'directionFormControl': new FormControl(this.group.technologieId),
      'profileInfoFormControl': new FormControl(this.group.profileId),
      'paymentStatusFormControl': new FormControl(this.group.payment),
      'studentPlannedToGraduate': new FormControl(this.group.studentPlannedToGraduate , [this.myValidator.bind(this)]),
      'studentPlannedToEnrollment': new FormControl(this.group.studentPlannedToEnrollment, [this.myValidator.bind(this)/*, Validators.pattern(/^[0-9]+[0-9]*$/)*/]),
      'studentActualFromControl': new FormControl({value: this.group.studentActual, disabled: true})
    });
  }

  isFormValid(): boolean {
    return this.signupForm.valid;
  }

  isDateVilid(): boolean {
    let startDate = new Date(this.signupForm.get('startDateFormControl').value).getTime();
    let endDate = new Date(this.signupForm.get('endDateFormControl').value).getTime();

    let startDateErrors = this.signupForm.controls.startDateFormControl;
    let endDateError = this.signupForm.controls.endDateFormControl;

    if (startDate && endDate != 0 && startDate > endDate) {
      startDateErrors.setErrors({'incorrect': true});
      endDateError.setErrors({'incorrect': true});
      return this.invalidDate = true;
    } else if (startDate && endDate != 0 && startDate <= endDate) {
      if (startDateErrors.errors != null || endDateError.errors != null) {
        startDateErrors.setErrors(null);
        endDateError.setErrors(null);
      }
      return this.invalidDate = false;
    }
    return false;
  }

  saveGroup() {

    if (this.isFormValid()) {
      this.group.setDataFromFormControl(this.signupForm);
      this.invalidForm = false;
      this.sendData();
      console.log('valid');

    } else {
      this.invalidForm = true;
      console.log('invalid');
    }
  }

  private sendData(){
    this.addGroupService.saveGroup(this.group).subscribe(res => {
      if(res==null || res == 200){
        this.openDialog();
      }
    },error => {
      this.errorOpenDialog();
      console.log(error)
    });
  }

  openDialog(): void {
    let dialogRef = this.dialog.open(DialogComponent, {
      data: {message: 'Group was successfully saved', err:false}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.router.navigate(['ang/viewAcademies']);
    });
  }

  errorOpenDialog(): void {
    let dialogRef = this.dialog.open(DialogComponent, {
      data: {message: 'Something goes wrong', err: true}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  updateGroup(){
    this.addGroupService.getGroupById(this.groupId).subscribe(group => {
      this.group.setDataToGroup(group);
      this.formGroupOnInit();

    },error => {
      console.log(error);
    });
  }

  myValidator(control: FormControl): { [s: string]: boolean } {
    let value;

    try{
      value = control.value.toLocaleString();
    } catch (e) {
      value = '0';
    }

    if (control.value < 0) {
      control.setValue(this.replace(value));
      return null;
    }
    else if(control.value > 99){
      control.setValue(0);
      return null;
    }
    return null;
  }

  replace(stringToReplace: string): number{
    stringToReplace = stringToReplace.replace(/\D/g, "");
    console.log(stringToReplace);
    return parseInt(stringToReplace, 10);
  }

}
