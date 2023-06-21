import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, tap } from "rxjs";
import { SecurityService } from "./security.service";
import { environment } from "src/environments/environment";

@Injectable()
export class SecurityInterceptor implements HttpInterceptor{

  constructor(private security:SecurityService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let clone = req

    if(this.security.jwtToken) {
      clone = req.clone({headers: req.headers.append(environment.jwtTokenName, this.security.jwtToken)})
    }

    return next.handle(clone).pipe(tap(event => {
      if(event instanceof HttpResponse) {
        this.security.jwtToken = event.headers.get(environment.jwtTokenName)
      }
    }))
  }

}
