import {Component, Injectable, OnInit} from '@angular/core';
import {MatIconRegistry} from '@angular/material';
import {ReportsService} from "../reports.service";
import {DomSanitizer} from "@angular/platform-browser";
import {Router} from "@angular/router";

@Component({
  selector: 'app-check-list-by-groups',
  templateUrl: './check-list-by-groups.component.html',
  styleUrls: ['./check-list-by-groups.component.css'],
  providers: [ReportsService]
})
@Injectable()
export class CheckListByGroupsComponent implements OnInit {
  groups: any;
  loadIndicatorVisible = true;

  constructor(private reportsService: ReportsService,
              iconRegistry: MatIconRegistry,
              sanitizer: DomSanitizer,
              private router: Router) {
    iconRegistry.addSvgIcon(
      'icon1',
      sanitizer.bypassSecurityTrustResourceUrl('assets/img/examples/ic_check_black_24px.svg'));
    iconRegistry.addSvgIcon(
      'icon0',
      sanitizer.bypassSecurityTrustResourceUrl('assets/img/examples/ic_close_black_24px.svg'));
  }

  ngOnInit() {
    this.reportsService.getAllForCheckListReport().subscribe(
      data => {
        this.groups = data;
        this.loadIndicatorVisible =false;
      },
      error => {
        if (error.status === 403) {
          this.router.navigate(['ang/error']);
        }
        console.log(error);
      }
    );

  }

  onMouseEnter(s: string) {
    let elementsByClassName = document.getElementsByClassName(s);
    for (let i = 0; i < elementsByClassName.length; i++) {
      elementsByClassName[i].setAttribute('style', 'background: oldlace; cursor: pointer;');
    }
  }

  onMouseLeave(s: string) {
    let elementsByClassName = document.getElementsByClassName(s);
    for (let i = 0; i < elementsByClassName.length; i++) {
      elementsByClassName[i].setAttribute('style', 'background: initial');
    }
  }

  onMouseClick(s: string) {
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
