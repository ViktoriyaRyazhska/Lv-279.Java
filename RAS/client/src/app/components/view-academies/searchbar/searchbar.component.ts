import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {SearchBarService} from "../search-bar.service";
import {Group} from "../../group/add-group/group.model";
import {Form, FormControl, FormGroup} from "@angular/forms";
import {DataService} from "../../../services/data.service";
import {FilterService} from "../filter.service";
import {AcademyService} from "../academy.service";

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
  startDateOpt = 'Equals';
  endDateOpt = 'Equals';
  @Output() filterData = new EventEmitter<{ form: Form }>();
  @Output() startDateOp = new EventEmitter<{ option: string }>();
  @Output() endDateOp = new EventEmitter<{ option: string }>();

  @Input('search') searchBar = true;


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

  startDateOption(event) {
    if (event.value === undefined) {
      this.startDateOpt = 'Equals';
    } else {
      this.startDateOpt = event.value.toString();
    }
    this.startDateOp.emit({option: this.startDateOpt});
  }

  endDateOption(event) {
    if (event.value === undefined) {
      this.endDateOpt = 'Equals';
    } else {
      this.endDateOpt = event.value.toString();
    }
    this.endDateOp.emit({option: this.endDateOpt});
  }

}
