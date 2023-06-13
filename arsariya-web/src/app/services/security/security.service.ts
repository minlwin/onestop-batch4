import { Injectable } from "@angular/core";
import { SecurityApi } from "../apis/security.api.service";
import { Observable, of, tap } from "rxjs";
import { LoginUser } from "../dto/login-user";

@Injectable({providedIn: 'root'})
export class SecurityService {

  private loginUser?:LoginUser

  constructor(private api:SecurityApi) {}

  signIn(form:any) {
    return this.api.signIn(form).pipe(tap(result => this.loginUser = result))
  }

  get loginId():string {
    if(this.loginUser) {
      return this.loginUser.email
    }

    return ''
    // throw({message: 'You have to login again.', type: 'Auth Error'})
  }

  signOut():Observable<any> {
    return of({})
  }
}
