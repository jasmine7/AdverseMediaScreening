import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NewSearchComponent } from './new-search.component';
import {NewSearchRoutingModule} from "./new-search-routing.module";
import {ReactiveFormsModule} from '@angular/forms';
import {LoadingIndicatorModule} from "../loading-indicator/loading-indicator.module";
import {ClientSearchModule} from "../client-search/client-search.module";

@NgModule({
  declarations: [NewSearchComponent],
    imports: [
      CommonModule,
      NewSearchRoutingModule,
      ReactiveFormsModule,
      LoadingIndicatorModule,
      ClientSearchModule
    ]
})
export class NewSearchModule { }
