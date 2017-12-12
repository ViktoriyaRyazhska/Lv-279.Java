import { Component, OnInit } from '@angular/core';
import {Router, Routes} from "@angular/router";


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
