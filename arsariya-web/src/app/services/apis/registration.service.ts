import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { ApiResult } from "../dto/api-result";
import { environment } from "src/environments/environment";
import { HttpClient } from "@angular/common/http";

const ADMIN_DOMAIN = `${environment.baseUrl}/admin/registration`
const STUDENT_DOMAIN = `${environment.baseUrl}/student/registration`

@Injectable({providedIn: 'any'})
export class RegistrationService {

  constructor(private http:HttpClient) {}

  searchForAdmin(form:any):Observable<ApiResult> {
    return this.http.get<ApiResult>(ADMIN_DOMAIN, {params: form})
  }

  purchaseCourse(form:any) {
    return of({})
  }
}
