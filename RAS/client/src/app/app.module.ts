import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';

import {HistoryListComponent} from './components/history/history-list/history-list.component';
import {ViewAcademiesComponent} from './components/view-academies/view-academies.component';
import {AddGroupComponent} from "./components/group/add-group/add-group.component";
import {AddGroupService} from "./components/group/add-group/add-group.service";
import {FilterPipe} from './components/view-academies/filter.pipe';
import {ProfileInfoFilterPipe} from './components/group/add-group/add-group.pipe';
import {AppRoutingModule} from "./app-routing.module";
import {LoginComponent} from './components/auth/login/login.component';
import {LoginService} from "./components/auth/login/login.service";
import {MyauthService} from "./components/auth/myauth.service";

import {StudentsComponent} from "./components/students/students.component";

import {FeedbackListComponent} from "./components/feedbacks/feedback-list/feedback-list.component";
import {MarkService} from "./services/feedbacks/marks.service";
import {FeedbackService} from "./services/feedbacks/feedback.service";
import {StudentsService} from "./services/students/students.service";
import {UsersService} from "./services/users/users.service";
import {MarkNamePipe} from "./components/feedbacks/feedback-list/mark-name.pipe";
import {MarkPipe} from "./components/feedbacks/feedback-list/mark.pipe";
import {HeaderComponent} from './components/header/header.component';
import {NavTabsComponent} from './components/nav-tabs/nav-tabs.component';
import {CheckListByGroupsComponent} from "./components/reports/check-list-by-groups/check-list-by-groups.component";
import {TestsNamesComponent} from "./components/tests-names/tests-names.component";
import {TestsService} from "./services/tests-names/tests.service";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {PrimeNgModules} from "./prime-ng.modules";
import {PaginationConfig, PaginationModule} from 'ngx-bootstrap';

import {
MatSortModule, MatIconModule, MatTableModule, MatPaginatorModule, MatSelectModule, MatRadioModule,
MatInputModule, MatExpansionModule} from "@angular/material";
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule, MatNativeDateModule, MatTabsModule, MatButtonModule, MatDialogModule} from '@angular/material'
import { FilterCheckListByGroupsComponent } from './components/reports/check-list-by-groups/filter-check-list-by-groups/filter-check-list-by-groups.component';
import { SearchbarComponent } from './components/view-academies/searchbar/searchbar.component';
import {SearchBarService} from "./components/view-academies/search-bar.service";
import {CookieService} from "angular2-cookie/core";
import { ErrorComponent } from './components/error/error.component';
import {JwtHelper} from "angular2-jwt";
import { EmployeeComponent } from './components/employee/employee.component';
import {BsModalRef, BsModalService, ComponentLoaderFactory, PositioningService, ModalBackdropComponent} from "ngx-bootstrap";
import {ModalContainerComponent} from "ngx-bootstrap/modal";
import {EmployeeService} from "./components/employee/employee.service";
import { DialogComponent } from './components/group/dialog/dialog.component';
import {DataService} from "./services/data.service";
import {ModalModule} from 'ngx-bootstrap/modal';
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import { ViewAcademiesNgxComponent } from './components/view-academies/view-academies-ngx/view-academies-ngx.component';
import {DxButtonModule, DxDataGridModule, DxLoadIndicatorModule} from "devextreme-angular";
import { ItaTacticalReportComponent } from './components/reports/ita-tactical-report/ita-tactical-report.component';
import {ItaTacticalReportService} from "./components/reports/ita-tactical-report/ita-tactical-report.service";
import { UpdateGroupComponent } from './components/group/update-group/update-group.component';
import { GroupOverviewByTraineesComponent } from './components/reports/group-overview-by-trainees/group-overview-by-trainees.component';
import { GroupNamesFilterPipe } from './components/reports/group-overview-by-trainees/group-names-filter.pipe';
import { GroupOverviewTableComponent } from './components/reports/group-overview-by-trainees/group-overview-table/group-overview-table.component';

@NgModule({
  declarations: [
    AppComponent,
    HistoryListComponent,
    ViewAcademiesComponent,
    AddGroupComponent,
    ViewAcademiesComponent,
    FilterPipe,
    StudentsComponent,
    ProfileInfoFilterPipe,
    StudentsComponent,
    FeedbackListComponent,
    MarkPipe,
    MarkNamePipe,
    LoginComponent,
    HeaderComponent,
    NavTabsComponent,
    CheckListByGroupsComponent,
    TestsNamesComponent,
    FilterCheckListByGroupsComponent,
    SearchbarComponent,
    FilterCheckListByGroupsComponent,
    ErrorComponent,
    EmployeeComponent,
    // ModalBackdropComponent,
    // ModalContainerComponent,
    ErrorComponent,
    DialogComponent,
    ViewAcademiesNgxComponent,
    UpdateGroupComponent,
    ViewAcademiesNgxComponent,
    ItaTacticalReportComponent,
    GroupOverviewByTraineesComponent,
    GroupNamesFilterPipe,
    GroupOverviewTableComponent
  ],
  entryComponents: [
    ModalBackdropComponent,
    ModalContainerComponent,
    DialogComponent],
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
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTabsModule,
    MatPaginatorModule,
    MatSelectModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    MatExpansionModule,
    PaginationModule,
    MatExpansionModule,
    MatDialogModule,
    ModalModule.forRoot(),
    NgxDatatableModule,
    DxButtonModule,
    DxDataGridModule,
    DxLoadIndicatorModule
  ],
  providers: [AddGroupService, StudentsService, LoginService, MyauthService, TestsService, UsersService, MarkService,
    FeedbackService, CookieService, SearchBarService, DataService, JwtHelper, BsModalService, BsModalRef,
    ComponentLoaderFactory, PositioningService,PaginationConfig,EmployeeService,ItaTacticalReportService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
