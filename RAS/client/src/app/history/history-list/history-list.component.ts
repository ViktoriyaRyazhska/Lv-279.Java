import { Component, OnInit } from '@angular/core';
import {HistoryService} from '../history.service';

@Component({
  selector: 'app-history-list',
  templateUrl: './history-list.component.html',
  styleUrls: ['./history-list.component.css'],
  providers: [HistoryService]
})

export class HistoryListComponent implements OnInit {
  historys: Array<any>;
  constructor(private historyService: HistoryService) {
  }

  ngOnInit() {
    this.historyService.getAll().subscribe(
      data => {
        this.historys = data;
      },
      error => console.log(error)
    );
  }

}


