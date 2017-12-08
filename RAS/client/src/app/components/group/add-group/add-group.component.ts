import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/map';
import {AddGroupService} from "./add-group.service";
import {HistoryService} from "../../history/history.service";
import {NgForm} from "@angular/forms";


@Component({
  selector: 'app-add-group',
  templateUrl: './add-group.component.html',
  styleUrls: ['./add-group.component.css'],
  providers:[HistoryService]
})
export class AddGroupComponent implements OnInit {

  academyStages: any[];
  cityNames: any[];
  direction: any[];
  technologie: any[];
  profile: any[];

  technologyModel: any;

  defaultStudentActual: number = 0;
  defaultStudentsPlannedToGraduate: number = 0;
  defaultStudentsPlannedToEnrollment: number = 0;

   defaultCity: any[] ;

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

    // this.defaultCity = this.cityNames.filter(cityNames=> cityNames.trasnlation=='Lviv');
  }

  saveGroup(form: NgForm) {
    // console.log(this.cityNames.filter(cityNames=> cityNames.trasnlation=='Lviv'));
    // console.log(this.defaultCity);
    console.log(form);
  }

  // onSubmit(form: NgForm) {
  //   console.log(form);
  // }


}
