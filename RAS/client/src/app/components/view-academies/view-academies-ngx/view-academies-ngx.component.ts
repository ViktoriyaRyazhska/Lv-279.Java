import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {AcademyService} from "../academy.service";
import {FilterService} from "../filter.service";
import {DataService} from "../../../services/data.service";
import {PagerService} from "../pager.service";

@Component({
  selector: 'app-view-academies-ngx',
  templateUrl: './view-academies-ngx.component.html',
  styleUrls: ['./view-academies-ngx.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers: [AcademyService, PagerService, FilterService]
})
export class ViewAcademiesNgxComponent implements OnInit {
  academies = [];
  rows = [];
  searchBar = true;
  startDateOpt = 'Equals';
  endDateOpt = 'Equals';
  addgroup = false;
  loadIndicatorVisible = true;

  constructor(private academyService: AcademyService,
              private filterService: FilterService) {
  }

  ngOnInit() {
    var startDate = new Date().getTime();
    this.academyService.getAll().subscribe(
      data => {
        this.academies = data;
        this.rows = this.academies;
        var endDate = new Date().getTime();
        this.loadIndicatorVisible = false;
        console.log("Time for executing method for returning group info : " + (endDate - startDate)/1000);
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

  showAddGroup() {
    this.addgroup = !this.addgroup;
  }
}
