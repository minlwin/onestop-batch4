import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { ApiResult } from "../dto/api-result";
import { environment } from "src/environments/environment";
import { HttpClient } from "@angular/common/http";

const ADMIN_DOMAIN = `${environment.baseUrl}/admin/teacher`

@Injectable({providedIn: 'root'})
export class TeacherService {

  constructor(private http:HttpClient) {}

  searchForAdmin(form:any):Observable<ApiResult> {
    return this.http.get<ApiResult>(ADMIN_DOMAIN, {params: form})
  }
}
