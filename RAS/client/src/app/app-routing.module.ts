import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

import {ViewAcademiesComponent} from "./components/view-academies/view-academies.component";
import {AddGroupComponent} from "./components/group/add-group/add-group.component";
import {HistoryListComponent} from "./components/history/history-list/history-list.component";
import {StudentsComponent} from "./components/students/students.component";
import {ItaTacticalPlanByGroupStageComponent} from "./components/reports/ita-tactical-plan-by-group-stage/ita-tactical-plan-by-group-stage.component";
import {CheckListByGroupsComponent} from "./components/reports/check-list-by-groups/check-list-by-groups.component";
import {TestsNamesComponent} from "./components/tests-names/tests-names.component";
import {LoginComponent} from "./components/auth/login/login.component";
import {HeaderComponent} from "./components/header/header.component";
import {FeedbacksComponent} from "./components/feedbacks/feedbacks.component";

const appRoutes: Routes = [
  {path: 'myLogin', component: LoginComponent},
  // {path: '', component: ViewAcademiesComponent},
  // {path: 'ang/addgroup', component: AddGroupComponent},
  {
    path: 'ang/addgroup', component: AddGroupComponent, children: [
    {path: '', redirectTo: 'students', pathMatch: 'full'},
    {path: 'students', component: StudentsComponent},
    {path: 'feedback', component: FeedbacksComponent},
    {path: 'history', component: HistoryListComponent}]
  },
  {path: 'ang/viewAcademies', component: ViewAcademiesComponent},
  {path: 'ang/students', component: StudentsComponent},
  {path: 'ang/feedback', component: FeedbacksComponent},
  {path: 'ang/reports/checkListByGroups', component: CheckListByGroupsComponent},
  {path: 'ang/ita-tactical-plan-by-group-stage', component: ItaTacticalPlanByGroupStageComponent},
  {path: 'ang/tests/:id', component: TestsNamesComponent},
  {path: 'ang', component: HeaderComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
