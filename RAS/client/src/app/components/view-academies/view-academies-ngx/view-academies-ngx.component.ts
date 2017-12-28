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

  // columns = [
  //   { name: 'Group Name'},
  //   {name: 'Students Planned To Graduate'},
  //   {name: 'Students Planned To Graduate'},
  //   {name: 'startDate', value: 'startDate | date: "dd.MM.yyyy"'}

  //   private String groupName;
  // private Integer studentsPlannedToGraduate;
  // private Integer studentsPlannedToEnrollment;
  // private Long startDate;
  // private Long endDate;
  // private Integer paymentStatus;
  // private String nameForSite;
  // private String profileName;
  // private String directionName;
  // private String commonDirectionName;
  // private String status;
  // private String cityName;
  // private Long studentsActual;
  // private List<String> firstName;
  // private List<String> lastName;
  // private Integer teacherType;
  // ];

  constructor(private academyService: AcademyService,
              private filterService: FilterService,
              private data: DataService) {
  }

  ngOnInit() {
    this.academyService.getAll().subscribe(
      data => {
        this.academies = data;
        this.academies = this.academies.slice(0, data.length);
        this.rows = this.academies;
      },
      error => console.log(error)
    );
    // this.data.currentMessage.subscribe(message => console.log(message));
  }

}
