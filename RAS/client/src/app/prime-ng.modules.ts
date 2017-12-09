import {ButtonModule, DataTableModule, DropdownModule} from 'primeng/primeng';
import {SplitButtonModule} from 'primeng/primeng';
import {PanelModule} from 'primeng/primeng';
import {NgModule} from "@angular/core";

@NgModule({
  exports: [
    PanelModule,
    ButtonModule,
    SplitButtonModule,
    DataTableModule,
    DropdownModule
  ]
})
export class PrimeNgModules {}
