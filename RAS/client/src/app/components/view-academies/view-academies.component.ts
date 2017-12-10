import {Component, OnInit, ViewChild} from '@angular/core';
import {AcademyService} from "./academy.service";
import {PagerService} from "./pager.service";
import {FilterService} from "./filter.service";
import {Form, NgForm} from "@angular/forms";
import * as moment from 'moment';

@Component({
  selector: 'app-view-academies',
  templateUrl: './view-academies.component.html',
  styleUrls: ['./view-academies.component.css'],
  providers: [AcademyService, PagerService, FilterService]
})
export class ViewAcademiesComponent implements OnInit {
  academies = [];
  filteredAcademies = [];
  fff = [];
  academyStages: any[];
  cityNames: any[];
  direction: any[];
  technology: any[];
  profile: any[];
  academyStagesItems = [{label: '---', value: ''}];
  cityItems = [{label: '---', value: ''}];
  directionItems = [{label: '---', value: ''}];
  profileItems = [{label: '---', value: ''}];
  technologyItems = [{label: '---', value: ''}];
  paymentStatusItems =
    [{label: '---', value: ''},
      {label: 'Founded by SoftServe', value: 'Founded by SoftServe'},
      {label: 'Paid', value: 'Paid'}
    ];

  yearFilter: number;
  date1: Date;

  pager: any = {};
  pagedItems = [];

  @ViewChild('inn') inn;

  constructor(private academyService: AcademyService,
              private pagerService: PagerService,
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
        for (const dir of this.direction) {
          this.directionItems.push({label: dir.name, value: dir.name});
        }
        for (const city of this.cityNames) {
          this.cityItems.push({label: city.trasnlation, value: city.trasnlation});
        }
        for (const prof of this.profile) {
          if (prof.profileName != null) {
            this.profileItems.push({label: prof.profileName, value: prof.profileName});
          }
        }
        for (const tech of this.technology) {
          this.technologyItems.push({label: tech.name, value: tech.name});
        }
        for (const ac of this.academyStages) {
          this.academyStagesItems.push({label: ac.name, value: ac.name});
        }


        this.setPage(1);
      },
      error => console.log(error)
    );
  }

  setPage(page: number) {
    if (page < 1 || page > this.pager.totalPages) {
      return;
    }

    // get pager object from service
    this.pager = this.pagerService.getPager(this.filteredAcademies.length, page);

    // get current page of items
    this.pagedItems = this.filteredAcademies.slice(this.pager.startIndex, this.pager.endIndex + 1);
  }

  onFilterField(event: Event, form) {
    // console.log(form.value);
    this.filteredAcademies = this.academies;
    Object.keys(form.value).forEach(key => {
      this.filteredAcademies = this.filterService.transform(this.filteredAcademies, form.value[key], key);
    });
    this.setPage(1);
  }

  onYearChange(event, dt, col) {
    // console.log(dt);
    // this.fff = dt.value;
    // Object.keys(dt.filters).forEach(key => {
    //   // console.log(dt.filters[key]);
    //   if(key === 'startDate')
    //     for(const data of this.fff){
    //       console.log(data);
    //       if(data[key].incldt.filters[key]){
    //
    //       }
    //   }
    // });

    // for (const data of dt.filters) {
    //   console.log(data);
    // }
    // dt.filter(event.value, col.field, col.filterMatchMode);
  }

}
