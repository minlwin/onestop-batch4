import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { PageResult } from "../dto/api-result";
import { environment } from "src/environments/environment";
import { HttpClient } from "@angular/common/http";

const ADMIN_DOMAIN = `${environment.baseUrl}/admin/students`


@Injectable({providedIn: 'any'})
export class StudentService {

  constructor(private http:HttpClient) {}

  // Admin
  searchForAdmin(form:any):Observable<PageResult> {
    return this.http.get<PageResult>(ADMIN_DOMAIN, {params: form})
  }

}
