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

  teacherSignUp(form:any) {
    return of({
      name: form.name,
      email: form.email,
      role: 'Teacher'
    })
  }

  studentSignUp(form:any) {
    return of({
      name: form.name,
      email: form.email,
      role: 'Student'
    })
  }
}
