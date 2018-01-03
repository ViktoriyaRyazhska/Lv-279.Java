import {Component, Input, OnInit} from '@angular/core';
import {HistoryService} from '../history.service';
import {MatTableDataSource} from "@angular/material";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-history-list',
  templateUrl: './history-list.component.html',
  styleUrls: ['./history-list.component.css'],
  providers: [HistoryService]
})

export class HistoryListComponent implements OnInit {
  @Input() groupId: number;

  academyId: number;
  dataTable;

  constructor(private historyService: HistoryService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.academyId = this.groupId;
    this.historyService.getAll(this.academyId).subscribe(
      data => {
        this.dataTable = data;
      },
      error => console.log(error)
    );
  }

}


