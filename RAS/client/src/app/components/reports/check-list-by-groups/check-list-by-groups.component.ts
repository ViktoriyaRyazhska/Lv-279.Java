import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource, MatSort} from '@angular/material';
import {ReportsService} from "../reports.service";

/**
 * @title Table with sorting
 */
@Component({
  selector: 'app-check-list-by-groups',
  templateUrl: './check-list-by-groups.component.html',
  styleUrls: ['./check-list-by-groups.component.css'],
  providers: [ReportsService]
})
export class CheckListByGroupsComponent {
  displayedColumns = ['groupName',
    'cityName',
    'status',
    'teachers',
    'experts',
    'r.englishLevelDefined',
    'r.englishLevelCorrect',
    'r.entryScoreDefined',
    'r.incomingTestDefined',
    'r.approvedByDefined',
    'r.teacherDefined',
    'r.expertDefined',
    'r.groupStartedSuccessfully'];
  groups: any;
  dataSource = new MatTableDataSource(this.groups);

  @ViewChild(MatSort) sort: MatSort;

  constructor(private reportsService: ReportsService) { }

  ngOnInit() {
    // this.loading = true;
    this.reportsService.getAllForCheckListReport().subscribe(
      data => {
        this.groups = data;
        this.dataSource = new MatTableDataSource(this.groups);
        this.dataSource.sort = this.sort;
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
