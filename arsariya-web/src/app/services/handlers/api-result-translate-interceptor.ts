import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from "@angular/common/http";
import { Observable, map } from "rxjs";

export class ApiResultTranslateInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(map(event => {

      // Normal Response
      if(event instanceof HttpResponse) {

        if(event.body.status) {
          if(event.body.status == 'Success') {
            return event.clone({body: event.body.result})
          } else {
            throw event.body
          }
        }
      }

      return event
    }))
  }
}
