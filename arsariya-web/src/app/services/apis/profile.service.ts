import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { environment } from "src/environments/environment";

const MEMBER_DOMAIN = `${environment.baseUrl}/member/profile`
const PUBLIC_DOMAIN = `${environment.baseUrl}/public/profile`

@Injectable({providedIn: 'any'})
export class ProfileService {

  // Teacher & Student
  uploadProfileImage(form: any):Observable<any> {
    return of({
      id: 1,
      name: 'Min Lwin',
      phone: '09782003098',
      email: 'minlwin@gmail.com',
      image: ''
    })
  }

  saveProfile(form:any):Observable<any> {
    return of(form)
  }

  // Public
  getProfile(loginId:string):Observable<any> {
    return of({
      id: 1,
      name: 'Min Lwin',
      phone: '09782003098',
      email: 'minlwin@gmail.com',
      image: ''
    })
  }

}
