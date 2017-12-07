import {FormsModule} from "@angular/forms";
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';

import {GroupListComponent} from './components/group/group-list/group-list.component';
import {GroupService} from './components/group/group.service';
import {HistoryListComponent} from './components/history/history-list/history-list.component';
import {ViewAcademiesComponent} from './components/view-academies/view-academies.component';
import {AddGroupComponent} from "./components/group/add-group/add-group.component";
import {AddGroupService} from "./components/group/add-group/add-group.service";
import {FilterPipe} from './components/view-academies/filter.pipe';
import {StudentsComponent} from "./components/students/students.component";
import {StudentsService} from "./services/students/students.service";
import {ProfileInfoFilterPipe} from "./components/group/add-group/add-group.pipe";
import {FeedbacksComponent} from "./components/feedbacks/feedbacks.component";
import {FeedbackListComponent} from "./components/feedbacks/feedback-list/feedback-list.component";
import {FeedbackItemComponent} from "./components/feedbacks/feedback-list/feedback-item/feedback-item.component";
import {FeedbackEditComponent} from "./components/feedbacks/feedback-edit/feedback-edit.component";
import {FeedbackTeacherEditComponent} from "./components/feedbacks/feedback-edit/feedback-teacher-edit/feedback-teacher-edit.component";
import {FeedbackExpertEditComponent} from "./components/feedbacks/feedback-edit/feedback-expert-edit/feedback-expert-edit.component";
import {FeedbackInterviewerEditComponent} from "./components/feedbacks/feedback-edit/feedback-interviewer-edit/feedback-interviewer-edit.component";
import {AppRoutingModule} from "./app-routing.module";
import {FeedbackTeacherDetailPipe} from "./components/feedbacks/feedback-edit/feedback-teacher-edit/feedback-teacher-edit.pipe";
import {HeaderComponent} from './components/header/header.component';
import {FeedbackDetailComponent} from "./components/feedbacks/feedback-detail/feedback-detail.component";
import {NavTabsComponent} from './components/nav-tabs/nav-tabs.component';
import {FeedbackService} from "./services/feedbacks/feedback.service";

@NgModule({
  declarations: [
    AppComponent,
    GroupListComponent,
    HistoryListComponent,
    ViewAcademiesComponent,
    AddGroupComponent,
    ViewAcademiesComponent,
    FilterPipe,
    StudentsComponent,
    ProfileInfoFilterPipe,
    StudentsComponent,
    FeedbacksComponent,
    FeedbackListComponent,
    FeedbackItemComponent,
    FeedbackDetailComponent,
    FeedbackEditComponent,
    FeedbackTeacherEditComponent,
    FeedbackExpertEditComponent,
    FeedbackInterviewerEditComponent,
    FeedbackTeacherDetailPipe,
    HeaderComponent,
    NavTabsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [GroupService, AddGroupService, StudentsService, FeedbackService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
