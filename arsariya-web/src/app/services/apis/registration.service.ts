import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { ApiResult } from "../dto/api-result";

@Injectable({providedIn: 'any'})
export class RegistrationService {

  searchForAdmin(form:any):Observable<ApiResult> {
    return of({
      status: 'Success',
      result: {
        list: [],
        pager: {
          current: 5,
          size: 10,
          totalCount: 51,
          totalPage: 20
        }
      }
    })
  }
}
