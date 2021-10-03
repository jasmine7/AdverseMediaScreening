import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {ToastNotificationService} from "../../features/toast-notification/toast-notification.service";

@Injectable()
export class HandleErrorsInterceptor implements HttpInterceptor{

  constructor(private toastService: ToastNotificationService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return new Observable((observer) => {
      next.handle(req).subscribe(
        (res: HttpResponse<any>) => {
          if (res instanceof HttpResponse) {
            observer.next(res);
            observer.complete();
          }
        },
        (err: HttpErrorResponse) => {
          console.error(err);
          this.toastService.createDangerToast(err.message, false);
          observer.complete();
        }
      )


    });
  }

}
