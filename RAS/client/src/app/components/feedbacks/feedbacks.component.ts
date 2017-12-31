import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.css']
})
export class FeedbacksComponent implements OnInit {
  @Input() groupId: number;

  constructor() {
  }

  ngOnInit() {

  }

}
