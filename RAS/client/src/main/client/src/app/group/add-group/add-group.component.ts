import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/map';
import {AddGroupService} from "./add-group.service";


@Component({
  selector: 'app-add-group',
  templateUrl: './add-group.component.html',
  styleUrls: ['./add-group.component.css']
})
export class AddGroupComponent implements OnInit {

  academyStages: any[];
  cityNames: any[];
  direction: any[];
  technologie: any[];
  profile: any[];

  defaultStudentActual: number = 0;


  // academyStages = [
  //   {'stageId': 1, 'name': 'Planned', 'sort': 2},
  //   {'stageId': 2, 'name': 'Boarding', 'sort': 1},
  //   {'stageId': 3, 'name': 'In Process', 'sort': 3},
  //   {'stageId': 4, 'name': 'Distributed', 'sort': 4},
  //   {'stageId': 5, 'name': 'Canceled', 'sort': 5},
  //   {'stageId': 6, 'name': 'Graduated', 'sort': 6},
  //   {'stageId': 7, 'name': 'Offering', 'sort': 7}
  // ];

  constructor(private addGroupService: AddGroupService) {
  }

  ngOnInit() {
    this.addGroupService.getAll().subscribe(resp => {
      this.academyStages = resp.academyStages;
      this.cityNames = resp.cityNames;
      this.direction = resp.direction;
      this.profile = resp.profile;
      this.technologie = resp.technologie;
    });
  }

  saveGroup() {
    console.log();
  }


}
