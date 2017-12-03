import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {GroupListComponent} from './group/group-list/group-list.component';
import {GroupService} from './group/group.service';
import {HistoryListComponent} from './history/history-list/history-list.component';
import {HistoryService} from './history/history.service';
import {ViewAcademiesComponent} from './view-academies/view-academies.component';
import {RouterModule, Routes} from "@angular/router";

const appRoutes: Routes = [
  {path: 'viewAcademies', component: ViewAcademiesComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    GroupListComponent,
    HistoryListComponent,
    ViewAcademiesComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [GroupService, HistoryService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
