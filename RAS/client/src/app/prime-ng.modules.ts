import {ButtonModule, DataTableModule, DialogModule, DropdownModule} from 'primeng/primeng';
import {SplitButtonModule} from 'primeng/primeng';
import {PanelModule} from 'primeng/primeng';
import {NgModule} from "@angular/core";
import {SharedModule} from "primeng/components/common/shared";
import {CalendarModule} from "primeng/components/calendar/calendar";
import {TabViewModule} from 'primeng/primeng';

@NgModule({
  exports: [
    PanelModule,
    ButtonModule,
    SplitButtonModule,
    DataTableModule,
    DropdownModule,
    SharedModule,
    CalendarModule,
    DialogModule,
    TabViewModule
  ]
})
export class PrimeNgModules {}
