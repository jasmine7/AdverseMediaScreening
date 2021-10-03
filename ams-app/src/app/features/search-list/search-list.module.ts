import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SearchListComponent} from "./search-list.component";
import {SearchListRoutingModule} from "./search-list-routing.module";
import {LoadingIndicatorModule} from "../loading-indicator/loading-indicator.module";
import {CustomPaginationModule} from "../custom-pagination/custom-pagination.module";


@NgModule({
  declarations: [SearchListComponent],
    imports: [
        CommonModule,
        SearchListRoutingModule,
        LoadingIndicatorModule,
        CustomPaginationModule
    ]
})
export class SearchListModule { }
