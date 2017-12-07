import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

import {ViewAcademiesComponent} from "./components/view-academies/view-academies.component";
import {AddGroupComponent} from "./components/group/add-group/add-group.component";
import {HistoryListComponent} from "./components/history/history-list/history-list.component";
import {StudentsComponent} from "./components/students/students.component";
import {FeedbackTeacherDetailComponent} from "./components/feedbacks/feedback-detail/feedback-teacher-detail/feedback-teacher-detail.component";
import {FeedbackInterviewerDetailComponent} from "./components/feedbacks/feedback-detail/feedback-interviewer-detail/feedback-interviewer-detail.component";

const appRoutes: Routes = [
  {path: 'ang/viewAcademies', component: ViewAcademiesComponent},
  {path: 'ang/addgroup', component: AddGroupComponent},
  {path: 'ang/history', component: HistoryListComponent},
  {path: 'ang/students', component: StudentsComponent},
  {path: 'ang/marks', component: FeedbackTeacherDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
