import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CustomPaginationComponent} from "./custom-pagination.component";
import {RouterModule} from "@angular/router";
import {CustomPaginationService} from "./custom-pagination.service";

@NgModule({
  declarations: [CustomPaginationComponent],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    CustomPaginationComponent
  ],
  providers: [
    CustomPaginationService
  ]
})
export class CustomPaginationModule { }
