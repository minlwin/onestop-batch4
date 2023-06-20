import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginUser } from "../dto/login-user";
import { environment } from "src/environments/environment";
import { HttpClient } from "@angular/common/http";

const DOMAIN = `${environment.baseUrl}/public/security`

@Injectable({providedIn: 'any'})
export class SecurityApi {

  constructor(private http:HttpClient) {}

  signIn(form:any):Observable<LoginUser> {
    return this.http.post<LoginUser>(DOMAIN, form)
  }

  teacherSignUp(form:any) {
    return this.http.post<LoginUser>(`${DOMAIN}/teacher`, form)
  }

  studentSignUp(form:any) {
    return this.http.post<LoginUser>(`${DOMAIN}/student`, form)
  }
}
