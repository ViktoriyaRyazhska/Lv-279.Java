import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {GroupListComponent} from './group/group-list/group-list.component';
import {GroupService} from './group/group.service';
import {HistoryListComponent} from './history/history-list/history-list.component';
import {ViewAcademiesComponent} from './view-academies/view-academies.component';
import {RouterModule, Routes} from "@angular/router";
import {AddGroupComponent} from "./group/add-group/add-group.component";
import {AddGroupService} from "./group/add-group/add-group.service";
import { FilterPipe } from './view-academies/filter.pipe';
import {FormsModule} from "@angular/forms";
import {StudentsComponent} from "./components/students/students.component";
import {StudentsService} from "./services/students/students.service";
import {ProfileInfoFilterPipe} from "./group/add-group/add-group.pipe";

const appRoutes: Routes = [
  {path: 'viewAcademies', component: ViewAcademiesComponent},
  {path: 'addgroup', component: AddGroupComponent},
  {path:'history', component: HistoryListComponent},
  {path:'students', component: StudentsComponent}
];

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
    ProfileInfoFilterPipe

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [GroupService, AddGroupService, StudentsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
