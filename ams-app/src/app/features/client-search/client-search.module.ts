import {NgModule} from "@angular/core";
import {ClientSearchComponent} from "./client-search.component";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {CommonModule} from "@angular/common";
import {AddNewClientModule} from "../add-new-client/add-new-client.module";

@NgModule({
  exports: [
    ClientSearchComponent
  ],
  imports: [
    ReactiveFormsModule,
    RouterModule,
    CommonModule,
    AddNewClientModule
  ],
  declarations: [
    ClientSearchComponent
  ]
})
export class ClientSearchModule {

}
