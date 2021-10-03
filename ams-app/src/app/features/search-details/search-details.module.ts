import {NgModule} from "@angular/core";
import {SearchDetailsComponent} from "./search-details.component";
import {CommonModule} from "@angular/common";
import {SearchDetailsRoutingModule} from "./search-details-routing.module";
import {ResultDetailsModule} from "../result-details/result-details.module";
import {LoadingIndicatorModule} from "../loading-indicator/loading-indicator.module";

@NgModule({
  declarations: [SearchDetailsComponent],
    imports: [
        CommonModule,
        SearchDetailsRoutingModule,
        ResultDetailsModule,
        LoadingIndicatorModule
    ]
})
export class SearchDetailsModule {

}
