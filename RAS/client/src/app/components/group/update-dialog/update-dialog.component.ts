import { Component, OnInit, Inject } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {Router} from "@angular/router";

@Component({
  selector: 'app-update-dialog',
  templateUrl: './update-dialog.component.html',
  styleUrls: ['./update-dialog.component.css']
})
export class UpdateDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<UpdateDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, private router:Router) { }

  ngOnInit() {}

  onNoClick(): void {
    this.dialogRef.close();
    if(!this.data.err){
      this.router.navigate(['ang/viewAcademies']);
    }
  }

}
