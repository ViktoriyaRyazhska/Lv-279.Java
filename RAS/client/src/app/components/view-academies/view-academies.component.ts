import {Component, OnInit} from '@angular/core';
import {AcademyService} from "./academy.service";
import {PagerService} from "./pager.service";
import {FilterService} from "./filter.service";

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
  propName = '';

  filteredSite = '';

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

  onFilterField(event: Event) {
    console.log(event);
    this.filteredSite = (<HTMLInputElement>event.target).value;
    this.propName = (<HTMLInputElement>event.target).name;
    if (this.filteredSite === '') {
      this.filteredAcademies = this.academies;
    } else {
      if (this.filteredAcademies.length === 0) {
        this.filteredAcademies = this.academies;
      }
      this.filteredAcademies = this.filterService.transform(this.filteredAcademies, this.filteredSite, this.propName);

    }
    this.setPage(1);
  }

  onClickFunc(event: Event) {
    console.log(event);
  }

}
