import {Component, ElementRef, OnDestroy, OnInit, QueryList, ViewChildren} from '@angular/core';
import {ToastNotificationService} from "./toast-notification.service";
import {ToastType} from "./toast-models/toast-type.model";
import {ToastNotification} from "./toast-models/toast-notification.model";
import {Subscription} from "rxjs";

declare let bootstrap: any;

@Component({
  selector: 'app-toast-notification',
  templateUrl: './toast-notification.component.html',
  styleUrls: ['./toast-notification.component.scss']
})
export class ToastNotificationComponent implements OnInit, OnDestroy {

  @ViewChildren('toastDiv', {read: ElementRef}) toastDivs: QueryList<ElementRef>

  toastType = ToastType;
  toastList: ToastNotification[] = [];
  toastSubscription: Subscription;

  constructor(public toastService: ToastNotificationService) {}

  ngOnInit(): void {
    this.toastSubscription = this.toastService.onToast()
      .subscribe(toast => {
      this.toastList.push(toast);
      if(toast.autoClose) {
        setTimeout(()=> this.removeToast(toast), 5000)
      }
    })
  }

  ngOnDestroy() {
    this.toastSubscription.unsubscribe();
  }

  removeToast(toast: ToastNotification) {
    if(!this.toastList.includes(toast)) return;
    this.toastList = this.toastList.filter(x => x != toast);
  }

  showToasts(){
    this.toastDivs.forEach((toastDiv: ElementRef) => {
      let bootstrapToast = new bootstrap.Toast(toastDiv.nativeElement);
      bootstrapToast.show();
    })
  }
}
