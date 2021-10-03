import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {SearchDetailsComponent} from "./search-details.component";

const routes: Routes = [
  {
    path: '',
    component: SearchDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SearchDetailsRoutingModule {

}
