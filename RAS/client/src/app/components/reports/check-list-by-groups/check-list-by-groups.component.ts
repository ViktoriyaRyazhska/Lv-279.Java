import { Component, OnInit } from '@angular/core';
import {ReportsService} from '../reports.service';
import {ChListGr} from "./ChListGr";

@Component({
  selector: 'app-check-list-by-groups',
  templateUrl: './check-list-by-groups.component.html',
  styleUrls: ['./check-list-by-groups.component.css'],
  providers: [ReportsService]
})
export class CheckListByGroupsComponent implements OnInit {
  groups: ChListGr;

  loading: boolean;

  constructor(private reportsService: ReportsService) { }

  ngOnInit() {
    // this.loading = true;
    this.reportsService.getAllForCheckListReport().subscribe(
      data => {
        this.groups = data;
      },
      error => console.log(error)
    );
  }

  myMouseEnter(s: string){
    let elementsByClassName = document.getElementsByClassName(s);
    for (let i = 0; i < elementsByClassName.length; i++) {
      elementsByClassName[i].setAttribute('style', 'background: oldlace; cursor: pointer;');
    }
  }

  myMouseLeave(s: string){
    let elementsByClassName = document.getElementsByClassName(s);
    for (let i = 0; i < elementsByClassName.length; i++) {
      elementsByClassName[i].setAttribute('style', 'background: initial');
    }
  }

  myMouseClick(s: string){
    let elementsByClassName = document.getElementsByClassName(s);
    for (let i = 0; i < elementsByClassName.length; i++) {
      if (!elementsByClassName[i].className.endsWith('master')) {
        let attribute = elementsByClassName[i].getAttribute('hidden');
        if (attribute) {
          elementsByClassName[i].removeAttribute('hidden');
        } else {
          elementsByClassName[i].setAttribute('hidden', '' + !attribute);
        }
      }
    }
  }


}
