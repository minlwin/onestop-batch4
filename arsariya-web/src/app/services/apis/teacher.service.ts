import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { ApiResult } from "../dto/api-result";
import { COURSES } from "./course.service";

@Injectable({providedIn: 'root'})
export class TeacherService {

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

  findPaymentMethod(loginId:string):Observable<any[]> {
    return of([
      {type: 'Wave Money', accountName: 'Min Lwin', accountNumber: '09782003098'},
      {type: 'KPAY', accountName: 'Min Lwin', accountNumber: '09782003098'},
      {type: 'Aya Pay', accountName: 'Min Lwin', accountNumber: '09782003098'},
    ])
  }

  findCourseForTeacher(loginId:string) {
    return of(COURSES)
  }
}
