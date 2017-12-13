import {FormsModule, ReactiveFormsModule} from "@angular/forms";
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
import {ProfileInfoFilterPipe} from './components/group/add-group/add-group.pipe';
import {FeedbacksComponent} from "./components/feedbacks/feedbacks.component";
import {FeedbackListComponent} from "./components/feedbacks/feedback-list/feedback-list.component";
import {FeedbackEditComponent} from "./components/feedbacks/feedback-edit/feedback-edit.component";
import {FeedbackTeacherEditComponent} from "./components/feedbacks/feedback-edit/feedback-teacher-edit/feedback-teacher-edit.component";
import {FeedbackExpertEditComponent} from "./components/feedbacks/feedback-edit/feedback-expert-edit/feedback-expert-edit.component";
import {FeedbackInterviewerEditComponent} from "./components/feedbacks/feedback-edit/feedback-interviewer-edit/feedback-interviewer-edit.component";
import {AppRoutingModule} from "./app-routing.module";
import { LoginComponent } from './components/auth/login/login.component';
import {LoginService} from "./components/auth/login/login.service";
import {MyauthService} from "./components/auth/myauth.service";
import {FeedbackTeacherEditPipe} from "./components/feedbacks/feedback-edit/feedback-teacher-edit/feedback-teacher-edit.pipe";
import {HeaderComponent} from './components/header/header.component';
import {NavTabsComponent} from './components/nav-tabs/nav-tabs.component';
import {FeedbackService} from "./services/feedbacks/feedback.service";
import {CheckListByGroupsComponent} from "./components/reports/check-list-by-groups/check-list-by-groups.component";
import {TestsNamesComponent} from "./components/tests-names/tests-names.component";
import {TestsService} from "./services/tests-names/tests.service";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {PrimeNgModules} from "./prime-ng.modules";
import {MarkService} from "./services/feedbacks/marks.service";
import {UsersService} from "./services/users/users.service";
import {MatSortModule, MatIconModule, MatTableModule, MatPaginatorModule, MatSelectModule, MatRadioModule, MatInputModule} from "@angular/material";
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule, MatNativeDateModule, MatTabsModule, MatButtonModule} from '@angular/material'
import {ItaTacticalPlanByGroupStageComponent} from "./components/reports/ita-tactical-plan-by-group-stage/ita-tactical-plan-by-group-stage.component";
import { ExporttoexcelComponent } from './components/exporttoexcel/exporttoexcel.component';



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
    FeedbackTeacherEditPipe,
    LoginComponent,
    FeedbackEditComponent,
    FeedbackTeacherEditComponent,
    FeedbackExpertEditComponent,
    FeedbackInterviewerEditComponent,
    FeedbackTeacherEditPipe,
    HeaderComponent,
    NavTabsComponent,
    ItaTacticalPlanByGroupStageComponent,
    CheckListByGroupsComponent,
    TestsNamesComponent,
    ExporttoexcelComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    PrimeNgModules,
    BrowserModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatSortModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTabsModule,
    MatSortModule,
    MatPaginatorModule,
    MatSelectModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule
  ],
  providers: [GroupService, AddGroupService, StudentsService, LoginService, MyauthService, FeedbackService, TestsService, UsersService, MarkService],

  bootstrap: [AppComponent]
})
export class AppModule {
}
