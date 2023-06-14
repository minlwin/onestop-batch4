import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { ApiResult } from "../dto/api-result";
import { COURSES } from "./course.service";

@Injectable({providedIn: 'any'})
export class StudentService {

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

  searchCourseForStudent(email:string):Observable<any[]> {
    return of(COURSES)
  }
}
