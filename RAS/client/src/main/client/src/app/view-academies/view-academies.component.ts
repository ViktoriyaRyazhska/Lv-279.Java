import {Component, OnInit} from '@angular/core';
import {AcademyService} from "./academy.service";
import {PagerService} from "./pager.service";

@Component({
  selector: 'app-view-academies',
  templateUrl: './view-academies.component.html',
  styleUrls: ['./view-academies.component.css'],
  providers: [AcademyService, PagerService]
})
export class ViewAcademiesComponent implements OnInit {
  private academies: any[];

  pager: any = {};

  pagedItems: any[];

  constructor(private academyService: AcademyService,
              private pagerService: PagerService) {
  }

  ngOnInit() {
    this.academyService.getAll().subscribe(
      data => {
        this.academies = data;

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
    this.pager = this.pagerService.getPager(this.academies.length, page);

    // get current page of items
    this.pagedItems = this.academies.slice(this.pager.startIndex, this.pager.endIndex + 1);
  }

}
