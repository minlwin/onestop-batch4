import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";

@Injectable({providedIn: 'any'})
export class ProfileService {

  getProfile(loginId:string):Observable<any> {
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
}
