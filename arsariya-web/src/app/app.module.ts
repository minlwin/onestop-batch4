import { ErrorHandler, NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppExceptionHandler } from './services/handlers/app-exception-handler';
import { WidgetsModule } from './commons/widgets/widgets.module';

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
    {provide: ErrorHandler, useClass: AppExceptionHandler}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
