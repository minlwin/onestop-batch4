import { ErrorHandler, Injectable, NgZone } from "@angular/core";
import { ErrorDialogComponent } from "src/app/commons/widgets/error-dialog/error-dialog.component";

@Injectable()
export class AppExceptionHandler implements ErrorHandler{

  errorDialog?:ErrorDialogComponent

  constructor(private zone:NgZone) {}

  handleError(error: any): void {

    console.log(error)

    if(error?.message) {
      if(this.errorDialog) {
        this.zone.run(() => this.errorDialog?.show(error?.message, error?.type))
      }
    } else {
      console.log(error)
    }
  }

}
