import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { ApiResult } from "../dto/api-result";
import { COURSES } from "./course.service";

@Injectable({providedIn: 'root'})
export class TeacherService {

  savePaymentMethod(form: any):Observable<any> {
    const {id, ... other} = form
    return id ? this.udpatePaymentMethod(id, other) : this.createPaymentMethod(other)
  }

  private createPaymentMethod(form:any):Observable<any> {
    return of(form)
  }

  private udpatePaymentMethod(id:number, form:any) {
    return of(form)
  }

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
      {id: 1, email: 'teacher@gmail.com', type: {id: 2, name: 'WAVE MONEY'}, accountName: 'Min Lwin', accountNumber: '09782003098'},
      {id: 2, email: 'teacher@gmail.com', type: {id: 1, name: 'KBZ PAY'}, accountName: 'Min Lwin', accountNumber: '09782003098'},
      {id: 3, email: 'teacher@gmail.com', type: {id: 3, name: 'AYA PAY'}, accountName: 'Min Lwin', accountNumber: '09782003098'},
    ])
  }

  findCourseForTeacher(loginId:string) {
    return of(COURSES)
  }
}
