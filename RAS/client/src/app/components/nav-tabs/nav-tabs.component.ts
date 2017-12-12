import { Component, OnInit } from '@angular/core';
import {Router, Routes} from "@angular/router";
import {ViewAcademiesComponent} from "../view-academies/view-academies.component";
import {AddGroupComponent} from "../group/add-group/add-group.component";
import {HistoryListComponent} from "../history/history-list/history-list.component";
import {StudentsComponent} from "../students/students.component";
import {LoginComponent} from "../auth/login/login.component";
import {FeedbackTeacherEditComponent} from "../feedbacks/feedback-edit/feedback-teacher-edit/feedback-teacher-edit.component";
import {CheckListByGroupsComponent} from "../reports/check-list-by-groups/check-list-by-groups.component";
import {ItaTacticalPlanByGroupStageComponent} from "../ita-tactical-plan-by-group-stage/ita-tactical-plan-by-group-stage.component";
import {TestsNamesComponent} from "../tests-names/tests-names.component";

@Component({
  selector: 'app-nav-tabs',
  templateUrl: './nav-tabs.component.html',
  styleUrls: ['./nav-tabs.component.css']
})
export class NavTabsComponent implements OnInit {
  routeLinks: any[];
  activeLinkIndex = -1;

  constructor(private router: Router) {
    this.routeLinks = [
      {
        label: 'Students',
        link: './students',
        index: 0
      }, {
        label: 'History',
        link: '/history',
        index: 1
      }, {
        label: 'Product 3',
        link: './product3',
        index: 2
      }, {
        label: 'Product 4',
        link: './product4',
        index: 3
      }, {
        label: 'Product 5',
        link: './product5',
        index: 4
      }
    ];
  }

  ngOnInit(): void {
    this.router.events.subscribe((res) => {
      this.activeLinkIndex = this.routeLinks.indexOf(this.routeLinks.find(tab => tab.link === '.' + this.router.url));
    });
  }
}
