import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-nav-tabs',
  templateUrl: './nav-tabs.component.html',
  styleUrls: ['./nav-tabs.component.css']
})
export class NavTabsComponent implements OnInit {
  @Input() academyId: number;
  @Input() techDirection : number;

  constructor() {}

  ngOnInit() {
  }
}
