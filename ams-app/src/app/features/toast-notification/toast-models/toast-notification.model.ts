import {ToastType} from "./toast-type.model";

export class ToastNotification {
  id: number;
  toastType: ToastType;
  message: string;
  dateTime: Date;
  autoClose: boolean;
}
