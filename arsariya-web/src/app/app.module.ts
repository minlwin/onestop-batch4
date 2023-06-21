import { ErrorHandler, NgModule } from '@angular/core';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http'
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppExceptionHandler } from './services/handlers/app-exception-handler';
import { WidgetsModule } from './commons/widgets/widgets.module';
import { SecurityInterceptor } from './services/security/security.interceptor';
import { ApiResultTranslateInterceptor } from './services/handlers/api-result-translate-interceptor';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    WidgetsModule,
    HttpClientModule
  ],
  providers: [
    {provide: ErrorHandler, useClass: AppExceptionHandler},
    {provide: HTTP_INTERCEPTORS, useClass: ApiResultTranslateInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: SecurityInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
