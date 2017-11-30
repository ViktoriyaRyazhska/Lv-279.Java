import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {GroupListComponent} from './group/group-list/group-list.component';
import {GroupService} from './group/group.service';
import {HistoryListComponent} from './history/history-list/history-list.component';
import {HistoryService} from './history/history.service';



@NgModule({
  declarations: [
    AppComponent,
    GroupListComponent,
    HistoryListComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [GroupService, HistoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
