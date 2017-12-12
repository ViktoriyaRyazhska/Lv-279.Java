import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource, MatSort} from '@angular/material';
import {ReportsService} from "../reports.service";

/**
 * @title Table with sorting
 */
@Component({
  selector: 'app-check-list-by-groups',
  templateUrl: './check-list-by-groups.component2.html',
  styleUrls: ['./check-list-by-groups.component.css'],
  providers: [ReportsService]
})
export class CheckListByGroupsComponent {
  displayedColumns = ['groupName', 'cityName', 'status', 'teachers'];
  groups: any;
  dataSource =  new MatTableDataSource(this.groups);

  @ViewChild(MatSort) sort: MatSort;

  /**
   * Set the sort after the view init since this component will
   * be able to query its view for the initialized sort.
   */
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

  /*onMouseEnter(s: string){
    let elementsByClassName = document.getElementsByClassName(s);
    for (let i = 0; i < elementsByClassName.length; i++) {
      elementsByClassName[i].setAttribute('style', 'background: oldlace; cursor: pointer;');
    }
  }

  onMouseLeave(s: string){
    let elementsByClassName = document.getElementsByClassName(s);
    for (let i = 0; i < elementsByClassName.length; i++) {
      elementsByClassName[i].setAttribute('style', 'background: initial');
    }
  }

  onMouseClick(s: string){
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
  }*/


}
