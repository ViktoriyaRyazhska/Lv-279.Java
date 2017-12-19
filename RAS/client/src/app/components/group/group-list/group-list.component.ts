import {Component, Injectable, OnInit} from '@angular/core';
import {GroupService} from '../group.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-group-list',
  templateUrl: './group-list.component.html',
  styleUrls: ['./group-list.component.css']
})
@Injectable()
export class GroupListComponent implements OnInit {
  academys: Array<any>;

  constructor(private groupService: GroupService,
              private router:Router) {
  }

  ngOnInit() {
    this.groupService.getAll().subscribe(data => {
        this.academys = data;
      },
      error => {
        this.router.navigate(['ang/error']);
        console.log(error)
      }
    );
  }

}

