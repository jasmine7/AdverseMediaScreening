import {NgModule} from "@angular/core";
import {ReversePipe} from "./pipes/reverse.pipe";
import {OrderByPipe} from "./pipes/order-by.pipe";

@NgModule({
  exports: [
    ReversePipe,
    OrderByPipe
  ],
  declarations: [
    ReversePipe,
    OrderByPipe
  ]
})
export class SharedModule { }
