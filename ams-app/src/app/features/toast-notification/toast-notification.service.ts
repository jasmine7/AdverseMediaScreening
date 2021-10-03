import {Injectable} from "@angular/core";
import {ToastNotification} from "./toast-models/toast-notification.model";
import {ToastType} from "./toast-models/toast-type.model";
import {Observable, Subject} from "rxjs";

@Injectable()
export class ToastNotificationService {

  private subject$ = new Subject<ToastNotification>();
  id: number = 1;

  constructor() {
  }

  onToast(): Observable<ToastNotification> {
    return this.subject$.asObservable();
  }

  private add(toastNotification: ToastNotification) {
    this.subject$.next(toastNotification);
  }

  private createToast(message: string, toastType: ToastType, autoClose: boolean){
    let toastNotification = new ToastNotification();
    toastNotification.id = this.id;
    this.id = this.id +1;
    toastNotification.toastType = toastType;
    toastNotification.message = message;
    toastNotification.dateTime = new Date();
    toastNotification.autoClose = autoClose;
    this.add(toastNotification);
  }

  createSuccessToast(message: string, autoClose: boolean) {
    this.createToast(message, ToastType.SUCCESS, autoClose);
  }

  createInfoToast(message: string, autoClose: boolean) {
    this.createToast(message, ToastType.INFO, autoClose);
  }

  createWarningToast(message: string, autoClose: boolean) {
    this.createToast(message, ToastType.WARNING, autoClose);
  }

  createDangerToast(message: string, autoClose: boolean) {
    this.createToast(message, ToastType.DANGER, autoClose);
  }
}
