import {Component, OnInit} from '@angular/core';
import {AcademyService} from "../academy.service";
import {FilterService} from "../filter.service";
import {DataService} from "../../../services/data.service";
import {PagerService} from "../pager.service";

@Component({
  selector: 'app-view-academies-ngx',
  templateUrl: './view-academies-ngx.component.html',
  styleUrls: ['./view-academies-ngx.component.css'],
  providers: [AcademyService, PagerService, FilterService]
})
export class ViewAcademiesNgxComponent implements OnInit {
  academies = [];
  rows = [];
  searchBar = true;
  startDateOpt = 'Equals';
  endDateOpt = 'Equals';

  constructor(private academyService: AcademyService,
              private filterService: FilterService,
              private data: DataService) {
  }

  ngOnInit() {
    this.academyService.getAll().subscribe(
      data => {
        let academiesArray = [] as any;
        for (let obj of data) {
          let expertsArray = [];
          let academy = {} as any;
          if (obj.firstName[0] != null) {
            expertsArray = [];
            for (let i = 0; i < obj.firstName.length; i++) {
              expertsArray.push(obj.firstName[i].toString() + ' ' + obj.lastName[i].toString());
            }
          }
          academy.academyId = obj.academyId;
          academy.cityName = obj.cityName;
          academy.commonDirectionName = obj.commonDirectionName;
          academy.directionName = obj.directionName;
          academy.endDate = obj.endDate;
          academy.experts = expertsArray;
          academy.groupName = obj.groupName;
          academy.nameForSite = obj.nameForSite;
          academy.paymentStatus = obj.paymentStatus;
          academy.profileName = obj.profileName;
          academy.startDate = obj.startDate;
          academy.status = obj.status;
          academy.studentsActual = obj.studentsActual;
          academy.studentsPlannedToEnrollment = obj.studentsPlannedToEnrollment;
          academy.studentsPlannedToGraduate = obj.studentsPlannedToGraduate;
          academy.teacherType = obj.teacherType;

          academiesArray.push(academy);
        }
        this.academies = academiesArray;
        this.rows = this.academies;
      },
      error => console.log(error)
    );
  }

  onFilterField(form) {
    this.rows = this.academies;
    Object.keys(form.form.value).forEach(key => {
      if (key === 'startDate') {
        this.rows = this.filterService.transformStartDate(this.rows, form.form.value[key], this.startDateOpt, key);
      } else if (key === 'endDate') {
        this.rows = this.filterService.transformEndDate(this.rows, form.form.value[key], this.endDateOpt, key);
      } else {
        this.rows = this.filterService.transform(this.rows, form.form.value[key], key);
      }
    });
  }

  showBar() {
    this.searchBar = !this.searchBar;
  }

  setStartDateOpt(event) {
    this.startDateOpt = event.option;
  }

  setEndDateOpt(event) {
    this.endDateOpt = event.option;
  }

}
