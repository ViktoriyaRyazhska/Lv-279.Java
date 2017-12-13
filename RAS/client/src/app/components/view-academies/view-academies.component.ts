import {Component, OnInit, ViewChild} from '@angular/core';
import {AcademyService} from "./academy.service";
import {PagerService} from "./pager.service";
import {FilterService} from "./filter.service";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-view-academies',
  templateUrl: './view-academies.component.html',
  styleUrls: ['./view-academies.component.css'],
  providers: [AcademyService, PagerService, FilterService]
})
export class ViewAcademiesComponent implements OnInit {
  academies = [];
  filteredAcademies = [];
  academyStages: any[];
  cityNames: any[];
  direction: any[];
  technology: any[];
  profile: any[];
  paymentStatus = [];

  displayedColumns =
    ['grName', 'nameForSite', 'technologyName', 'profileName',
      'paymentStatus', 'cityName', 'startDate', 'endDate',
      'experts', 'studentPlannedToGraduate', 'studentPlannedToEnrollment',
      'studentsActual', 'hiredNotGraduated', 'directionName', 'interviewerFeedback'
    ];
  dataSource: any;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;


  constructor(private academyService: AcademyService,
              private filterService: FilterService) {
  }

  ngOnInit() {
    this.academyService.getAll().subscribe(
      data => {
        this.academies = data;
        this.academies = this.academies.slice(0, data.length - 2);
        this.filteredAcademies = this.academies;

        this.academyStages = data[data.length - 1].academyStages;
        this.cityNames = data[data.length - 1].cityNames;
        this.direction = data[data.length - 1].direction;
        this.profile = data[data.length - 1].profile;
        this.technology = data[data.length - 1].technologie;

        this.dataSource = new MatTableDataSource<Element>(this.filteredAcademies);

        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;

        this.paymentStatus = ['Founded by SoftServe', 'Paid'];
      },
      error => console.log(error)
    );
  }
  onFilterField(event: Event, form) {
    this.filteredAcademies = this.academies;
    Object.keys(form.value).forEach(key => {
      this.filteredAcademies = this.filterService.transform(this.filteredAcademies, form.value[key], key);
      this.dataSource = new MatTableDataSource<Element>(this.filteredAcademies);
      this.dataSource.paginator = this.paginator;
    });
  }
}
