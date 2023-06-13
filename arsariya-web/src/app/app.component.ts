import { AfterViewInit, Component, ErrorHandler, Inject, ViewChild } from '@angular/core';
import { ErrorDialogComponent } from './commons/widgets/error-dialog/error-dialog.component';
import { AppExceptionHandler } from './services/handlers/app-exception-handler';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: []
})
export class AppComponent implements AfterViewInit{

  title = 'Arsariya';

  @ViewChild(ErrorDialogComponent)
  errorDialog?:ErrorDialogComponent

  constructor(@Inject(ErrorHandler) private errorHandler:AppExceptionHandler) {}

  ngAfterViewInit(): void {
    this.errorHandler.errorDialog = this.errorDialog
  }

}
