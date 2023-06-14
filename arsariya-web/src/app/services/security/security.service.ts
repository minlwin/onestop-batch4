import { Injectable } from "@angular/core";
import { SecurityApi } from "../apis/security.api.service";
import { Observable, of, tap } from "rxjs";
import { LoginUser } from "../dto/login-user";

const LOGIN_USER_KEY = 'jdc.learner.loginuser'

@Injectable({providedIn: 'root'})
export class SecurityService {

  private loginUser?:LoginUser

  constructor(private api:SecurityApi) {
    let loginUserString = localStorage.getItem(LOGIN_USER_KEY)
    if(loginUserString) {
      this.loginUser = JSON.parse(loginUserString)
    }
  }

  signIn(form:any) {
    return this.api.signIn(form).pipe(tap(result => {
      this.loginUser = result
      localStorage.setItem(LOGIN_USER_KEY, JSON.stringify(result))
    }))
  }

  get loginId():string {
    if(this.loginUser) {
      return this.loginUser.email
    }

    throw({message: 'You have to login again.', type: 'Auth Error'})
  }

  get role():string {
    if(this.loginUser) {
      return this.loginUser.role
    }

    return 'Anonymous'
  }

  signOut():Observable<any> {
    this.loginUser = undefined
    localStorage.removeItem(LOGIN_USER_KEY)
    return of({})
  }
}
