import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SearchBarService} from "../search-bar.service";
import {Group} from "../../group/add-group/group.model";
import {Form, FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent implements OnInit {

  academyStages: any[];
  cityNames: any[];
  direction: any[];
  technology: any[];
  profile: any[];
  paymentStatus = [];
  @Output() filterData = new EventEmitter<{form: Form}>();


  constructor(private searchBarServise: SearchBarService) {
  }

  ngOnInit() {
    this.searchBarServise.getAll().subscribe(
      data => {
        console.log(data);
        this.academyStages = data.academyStages;
        this.cityNames = data.cityNames;
        this.direction = data.direction;
        this.profile = data.profile;
        this.technology = data.technologie;
        this.paymentStatus = ['Founded by SoftServe', 'Paid'];
      },
      error => console.log(error)
    );
  }

  getFilter(form) {
    this.filterData.emit({form: form});
  }
}
