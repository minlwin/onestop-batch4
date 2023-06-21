import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { PageResult } from "../dto/api-result";
import { environment } from "src/environments/environment";
import { HttpClient } from "@angular/common/http";

const ADMIN_DOMAIN = `${environment.baseUrl}/admin/registration`
const STUDENT_DOMAIN = `${environment.baseUrl}/student/registration`

@Injectable({providedIn: 'any'})
export class RegistrationService {

  constructor(private http:HttpClient) {}

  searchForAdmin(form:any):Observable<PageResult> {
    return this.http.get<PageResult>(ADMIN_DOMAIN, {params: form})
  }

  purchaseCourse(form:any) {
    return this.http.post<any>(STUDENT_DOMAIN, form)
  }
}
