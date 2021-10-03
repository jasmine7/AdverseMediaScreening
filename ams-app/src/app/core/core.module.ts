import {NgModule, Optional, SkipSelf} from '@angular/core';
import {HeaderComponent} from './header/header.component';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {KeywordService} from "./services/keyword.service";
import {ClientService} from "./services/client.service";
import {SearchService} from "./services/search.service";
import {ScrollToTopComponent} from './scroll-to-top/scroll-to-top.component';
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {HandleErrorsInterceptor} from "./interceptors/handle-errors.interceptor";
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginComponent } from './login/login.component';
import {ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "./services/auth.service";
import {AuthInterceptor} from "./interceptors/auth.interceptor";
import {AuthGuard} from "./guards/auth.guard";
import {DecisionService} from "./services/decision.service";
import {ResultService} from "./services/result.service";

@NgModule({
  declarations: [
    HeaderComponent,
    ScrollToTopComponent,
    PageNotFoundComponent,
    LoginComponent
  ],
  exports: [
    HeaderComponent,
    ScrollToTopComponent,
    PageNotFoundComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    ReactiveFormsModule
  ],
  providers: [
    AuthGuard,
    KeywordService,
    ClientService,
    SearchService,
    ResultService,
    DecisionService,
    AuthService,
    [
      {
        provide: HTTP_INTERCEPTORS,
        useClass: HandleErrorsInterceptor,
        multi: true,
      },
      {
        provide: HTTP_INTERCEPTORS,
        useClass: AuthInterceptor,
        multi: true
      }
    ]
  ]
})
export class CoreModule {
  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    if (parentModule){
      throw new Error('CoreModule is already loaded. Import it in the AppModule only');
    }
  }
}
