import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import {Group} from "../components/group/add-group/group.model";

@Injectable()
export class DataService {

  // private messageSource = new BehaviorSubject<string>("default message");
  // currentMessage = this.messageSource.asObservable();

  // group: Group = {
  //   grName: 'Group Name',
  //   nameForSite: 'Name for Site',
  // academyStagesId: 1,
  // startDate: null,
  // endDate: null,
  // paymentStatus: 1,
  // cityId: 1,
  // directionId: null,
  // technologieId: null,
  // profileId: null,
  // studentPlannedToGraduate: 0,
  // studentPlannedToEnrollment: 0,
  // studentActual: 0
  // }

  group: Group = new Group();

  private someObj = new BehaviorSubject<Group>(this.group);
  currentMessage = this.someObj.asObservable();

  constructor() { }

  setGroup(group: Group) {
    this.someObj.next(group);
  }

}
