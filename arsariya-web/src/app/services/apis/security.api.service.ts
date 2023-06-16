import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { LoginUser } from "../dto/login-user";
import { environment } from "src/environments/environment";

const DOMAIN = `${environment.baseUrl}/public/security`

@Injectable({providedIn: 'any'})
export class SecurityApi {

  signIn(form:any):Observable<LoginUser> {
    return of({
      id: 1,
      name: form.password,
      email: form.email,
      role: form.password
    })
  }

  teacherSignUp(form:any) {
    return of({
      id: 1,
      name: form.name,
      email: form.email,
      role: 'Teacher'
    })
  }

  studentSignUp(form:any) {
    return of({
      id: 1,
      name: form.name,
      email: form.email,
      role: 'Student'
    })
  }
}
