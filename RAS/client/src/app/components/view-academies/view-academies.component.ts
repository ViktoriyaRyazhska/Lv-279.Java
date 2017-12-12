import {Component, OnInit, ViewChild} from '@angular/core';
import {AcademyService} from "./academy.service";
import {PagerService} from "./pager.service";
import {FilterService} from "./filter.service";
import {Form, NgForm} from "@angular/forms";
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

  pager: any = {};
  pagedItems = [];

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


        // this.setPage(1);
      },
      error => console.log(error)
    );
  }

//
//   setPage(page: number) {
//     if (page < 1 || page > this.pager.totalPages) {
//       return;
//     }
//
//     // get pager object from service
//     this.pager = this.pagerService.getPager(this.filteredAcademies.length, page);
//
//     // get current page of items
//     this.pagedItems = this.filteredAcademies.slice(this.pager.startIndex, this.pager.endIndex + 1);
//   }
//
  onFilterField(event: Event, form) {
    // console.log(form.value);
    this.filteredAcademies = this.academies;
    Object.keys(form.value).forEach(key => {
      this.filteredAcademies = this.filterService.transform(this.filteredAcademies, form.value[key], key);
      this.dataSource = new MatTableDataSource<Element>(this.filteredAcademies);
      this.dataSource.paginator = this.paginator;
    });
  }

//
//   onClickFunc(event: Event) {
//     console.log(event);
//   }
//
//   typeOfFiltering(event){
//     console.log(event);
//   }
//
// }
}
