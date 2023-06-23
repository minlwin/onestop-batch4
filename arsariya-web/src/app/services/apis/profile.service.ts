import { HttpClient, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

const MEMBER_DOMAIN = `${environment.baseUrl}/member/profile`
const PUBLIC_DOMAIN = `${environment.baseUrl}/public/profile`

@Injectable({providedIn: 'any'})
export class ProfileService {

  constructor(private http:HttpClient) {}

  // Teacher & Student
  uploadProfileImage(file: File):Observable<any> {
    const form = new FormData
    form.append('file', file, file.name)
    return this.http.post<any>(`${MEMBER_DOMAIN}/image`, form)
  }

  saveProfile(form:any):Observable<any> {
    return this.http.put<any>(MEMBER_DOMAIN, form)
  }

  // Public
  getProfile(loginId:string):Observable<any> {
    return this.http.get<any>(PUBLIC_DOMAIN, {params: {loginId: loginId}})
  }

}
