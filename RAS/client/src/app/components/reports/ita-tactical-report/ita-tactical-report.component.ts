import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ItaTacticalReportService} from "./ita-tactical-report.service";


@Component({
  selector: 'app-ita-tactical-report',
  templateUrl: './ita-tactical-report.component.html',
  styleUrls: ['./ita-tactical-report.component.css']
})
export class ItaTacticalReportComponent implements OnInit {

  itaTacticalPlanReports = [];

  constructor(private itaTacticalReportService: ItaTacticalReportService,
              private router: Router) {
  }

  calculateCellValue(data) {
    return  data.paymentSatus == 1 ? "Founded by Softserve" : "Open group";
  }

  ngOnInit() {
    this.itaTacticalReportService.getAll().subscribe(
      data => {
        this.itaTacticalPlanReports = data;
            },
      error => {
        if (error.status === 403) {
          this.router.navigate(['ang/error']);
        }
        console.log(error)
      }
    );
    ;
  }

}
