import {ButtonModule, DataTableModule, DialogModule, DropdownModule} from 'primeng/primeng';
import {SplitButtonModule} from 'primeng/primeng';
import {PanelModule} from 'primeng/primeng';
import {NgModule} from "@angular/core";
import {SharedModule} from "primeng/components/common/shared";
import {CalendarModule} from "primeng/components/calendar/calendar";
import {TabViewModule} from 'primeng/primeng';
import {SpinnerModule} from 'primeng/primeng';
import {CheckboxModule} from "primeng/components/checkbox/checkbox";
import {InputTextareaModule} from 'primeng/primeng';
import {RadioButtonModule} from 'primeng/primeng';


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
    TabViewModule,
    CheckboxModule,
    TabViewModule,
    SpinnerModule,
    InputTextareaModule,
    RadioButtonModule
  ]
})
export class PrimeNgModules {}
