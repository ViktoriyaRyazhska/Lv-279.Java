import {Component, OnInit} from '@angular/core';
import {HistoryService} from '../history.service';
import {MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-history-list',
  templateUrl: './history-list.component.html',
  styleUrls: ['./history-list.component.css'],
  providers: [HistoryService]
})

export class HistoryListComponent implements OnInit {
  displayedColumns = ['academyName', 'nameForSite', 'location', 'sartDate', 'endDate', 'sartDate', 'stage', 'direction'
    , 'modifyDate', 'modifyBy'];
  dataSource = new MatTableDataSource();


  constructor(private historyService: HistoryService) {
  }

  ngOnInit() {
    this.historyService.getAll().subscribe(
      data => {
        this.dataSource = new MatTableDataSource(data);
      },
      error => console.log(error)
    );
  }

}


