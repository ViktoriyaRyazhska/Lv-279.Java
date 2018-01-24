import {Component, Input, OnInit, ViewChild} from '@angular/core';

@Component({
  selector: 'app-nav-tabs',
  templateUrl: './nav-tabs.component.html',
  styleUrls: ['./nav-tabs.component.css']
})
export class NavTabsComponent implements OnInit {
  @Input() academyId: number;
  @Input() techDirection : number;
  @ViewChild('appTestNames') child;

  getAppTestNamesTemplate (directId:number){
    this.child.getTestsTemplate(directId);
  }
  updateTestNameTab(){
    this.child.updateTab();
  }
  constructor() {}

  ngOnInit() {
  }
}
