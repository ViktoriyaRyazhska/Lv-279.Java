import {Component, OnInit} from '@angular/core';
import {GroupService} from '../group.service';

@Component({
  selector: 'app-group-list',
  templateUrl: './group-list.component.html',
  styleUrls: ['./group-list.component.css']
})
export class GroupListComponent implements OnInit {
  academys: Array<any>;

  constructor(private groupService: GroupService) {
  }

  ngOnInit() {
    this.groupService.getAll().subscribe(data => {
        this.academys = data;
      },
      error => console.log(error)
    );
  }

}

