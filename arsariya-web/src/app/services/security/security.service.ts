import { Injectable } from "@angular/core";
import { SecurityApi } from "../apis/security.api.service";
import { Observable, of, tap } from "rxjs";
import { LoginUser } from "../dto/login-user";

const LOGIN_USER_KEY = 'jdc.learner.loginuser'
const APP_TOKEN_KEY = 'jdc.learner.token'

@Injectable({providedIn: 'root'})
export class SecurityService {

  private loginUser?:LoginUser
  private _jwtToken?:string

  constructor(private api:SecurityApi) {
    let loginUserString = localStorage.getItem(LOGIN_USER_KEY)
    if(loginUserString) {
      this.loginUser = JSON.parse(loginUserString)
    }

    this.jwtToken = localStorage.getItem(APP_TOKEN_KEY)
  }

  signIn(form:any) {
    return this.api.signIn(form).pipe(tap(this.fetchUser))
  }

  teacherSignUp(form:any) {
    return this.api.teacherSignUp(form).pipe(tap(this.fetchUser))
  }

  studentSignUp(form:any) {
    return this.api.studentSignUp(form).pipe(tap(this.fetchUser))
  }


  private fetchUser = (result:any) => {
    this.loginUser = result
    localStorage.setItem(LOGIN_USER_KEY, JSON.stringify(result))
  }

  get loginUserName() {
    if(this.loginUser) {
      return this.loginUser.name
    }

    throw({message: 'You have to login again.', type: 'Auth'})
  }

  get loginId():string {
    if(this.loginUser) {
      return this.loginUser.email
    }

    return ""
  }

  get role():string {
    if(this.loginUser) {
      return this.loginUser.role
    }

    return 'Anonymous'
  }

  get jwtToken() {
    return this._jwtToken;
  }

  set jwtToken(data:string | null | undefined) {
    if(data) {
      this._jwtToken = data
      localStorage.setItem(APP_TOKEN_KEY, data)
    } else {
      this.signOut()
    }
  }

  signOut() {
    this.loginUser = undefined
    this._jwtToken = undefined
    localStorage.removeItem(LOGIN_USER_KEY)
    localStorage.removeItem(APP_TOKEN_KEY)
  }
}
