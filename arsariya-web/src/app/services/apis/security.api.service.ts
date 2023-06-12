import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { LoginUser } from "../dto/login-user";

@Injectable({providedIn: 'any'})
export class SecurityApi {

  signIn(form:any):Observable<LoginUser> {
    return of({
      name: form.password,
      email: form.email,
      role: form.password
    })
  }
}
