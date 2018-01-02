import {Component, OnInit, ViewChild} from '@angular/core';
import {AcademyService} from "./academy.service";
import {PagerService} from "./pager.service";
import {FilterService} from "./filter.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {SearchBarService} from "./search-bar.service";
import {Form} from "@angular/forms";
import {DataService} from "../../services/data.service";

@Component({
  selector: 'app-view-academies',
  templateUrl: './view-academies.component.html',
  styleUrls: ['./view-academies.component.css'],
  providers: [AcademyService, PagerService, FilterService]
})
export class ViewAcademiesComponent implements OnInit {
  academies = [];
  filteredAcademies = [];

  displayedColumns =
    ['groupName', 'nameForSite',
      'directionName', 'profileName', 'cityName', 'startDate', 'endDate', 'status',
      'experts', 'studentPlannedToGraduate', 'studentPlannedToEnrollment',
      'studentsActual', 'hiredNotGraduated', 'commonDirectionName', 'interviewerFeedback'
    ];
  dataSource: any;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private academyService: AcademyService,
              private filterService: FilterService,
              private data: DataService) {
  }

  ngOnInit() {
    this.academyService.getAll().subscribe(
      data => {
        this.academies = data;
        this.academies = this.academies.slice(0, data.length);

        this.filteredAcademies = this.academies;

        this.dataSource = new MatTableDataSource(this.filteredAcademies);

        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;

        console.log(this.academies);
      },
      error => console.log(error)
    );
    // this.data.currentMessage.subscribe(message => console.log(message));
  }

  onFilterField(form) {
    this.filteredAcademies = this.academies;
    Object.keys(form.form.value).forEach(key => {
      if (key === 'startDate') {
        this.filteredAcademies = this.filterService.transformStartDate(this.filteredAcademies, form.form.value[key], form.form.value['startDateOption'], key);
      } else if (key === 'endDate') {
        this.filteredAcademies = this.filterService.transformEndDate(this.filteredAcademies, form.form.value[key], form.form.value['endDateOption'], key);
      } else {
        this.filteredAcademies = this.filterService.transform(this.filteredAcademies, form.form.value[key], key);
      }
      this.dataSource = new MatTableDataSource<Element>(this.filteredAcademies);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  sendDataToAddGroupComponent(group: any){
    this.data.setGroup(group);
  }
}
