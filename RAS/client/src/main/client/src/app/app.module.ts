import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {GroupListComponent} from './group/group-list/group-list.component';
import {GroupService} from './group/group.service';
import {HistoryListComponent} from './history/history-list/history-list.component';
import {HistoryService} from './history/history.service';
import {ViewAcademiesComponent} from './view-academies/view-academies.component';
import {RouterModule, Routes} from "@angular/router";
import { FilterPipe } from './view-academies/filter.pipe';
import {FormsModule} from "@angular/forms";

const appRoutes: Routes = [
  {path: 'viewAcademies', component: ViewAcademiesComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    GroupListComponent,
    HistoryListComponent,
    ViewAcademiesComponent,
    FilterPipe

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [GroupService, HistoryService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
