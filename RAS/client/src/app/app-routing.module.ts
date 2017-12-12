import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

import {ViewAcademiesComponent} from "./components/view-academies/view-academies.component";
import {AddGroupComponent} from "./components/group/add-group/add-group.component";
import {HistoryListComponent} from "./components/history/history-list/history-list.component";
import {StudentsComponent} from "./components/students/students.component";
import {FeedbackTeacherEditComponent} from "./components/feedbacks/feedback-edit/feedback-teacher-edit/feedback-teacher-edit.component";
import {FeedbacksComponent} from "./components/feedbacks/feedbacks.component";
import {FeedbackEditComponent} from "./components/feedbacks/feedback-edit/feedback-edit.component";
import {FeedbackListComponent} from "./components/feedbacks/feedback-list/feedback-list.component";
import {ItaTacticalPlanByGroupStageComponent} from "./components/ita-tactical-plan-by-group-stage/ita-tactical-plan-by-group-stage.component";
import {CheckListByGroupsComponent} from "./components/reports/check-list-by-groups/check-list-by-groups.component";
import {TestsNamesComponent} from "./components/tests-names/tests-names.component";
import {LoginComponent} from "./components/auth/login/login.component";

const appRoutes: Routes = [
  // {path: '', component: ViewAcademiesComponent},
  {path: 'myLogin', component: LoginComponent},
  {path: 'ang/addgroup', component: AddGroupComponent},
  {path: 'ang/viewAcademies', component: ViewAcademiesComponent},
  {path: 'ang/students', component: StudentsComponent},
  {path: 'ang/feedback', component: FeedbacksComponent},
  {path: 'ang/reports/checkListByGroups', component: CheckListByGroupsComponent},
  {path: 'ang/ita-tactical-plan-by-group-stage', component: ItaTacticalPlanByGroupStageComponent},
  {path: 'ang/tests', component: TestsNamesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
