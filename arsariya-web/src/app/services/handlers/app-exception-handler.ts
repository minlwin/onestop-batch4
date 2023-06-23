import { ErrorHandler, Injectable, NgZone } from "@angular/core";
import { ErrorDialogComponent } from "src/app/commons/widgets/error-dialog/error-dialog.component";

@Injectable()
export class AppExceptionHandler implements ErrorHandler{

  errorDialog?:ErrorDialogComponent

  constructor(private zone:NgZone) {}

  handleError(error: any): void {

    let message:any
    let type:any

    if(error.error) {
      message = error.error.result
      type = error.error.status
    } else if(error?.message && error?.status) {
      message = error.message
      type = error.status
    } else {
      message = error.message || "Angular Platform Error"
      type= "Angular"
    }

    console.log(`Type : ${type}, Message : ${message}`)

    if(this.errorDialog && message && type) {
      this.zone.run(() => {
        this.errorDialog?.show(message, type)
      })
    }

  }

}
