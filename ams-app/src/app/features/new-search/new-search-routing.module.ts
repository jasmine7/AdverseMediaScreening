import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {NewSearchComponent} from "./new-search.component";

const routes: Routes = [
  {
    path: '',
    component: NewSearchComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NewSearchRoutingModule {

}
