import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToastNotificationComponent } from './toast-notification.component';
import {ToastNotificationService} from "./toast-notification.service";
import {SharedModule} from "../../shared/shared.module";



@NgModule({
  declarations: [ToastNotificationComponent],
  exports: [
    ToastNotificationComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  providers: [
    ToastNotificationService
  ]

})
export class ToastNotificationModule { }
