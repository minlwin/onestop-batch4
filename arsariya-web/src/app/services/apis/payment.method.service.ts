import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { environment } from "src/environments/environment";

const ADMIN_DOMAIN = `${environment.baseUrl}/admin/payment`
const TEACHER_DOMAIN = `${environment.baseUrl}/teacher/payment`

@Injectable({providedIn: 'any'})
export class PaymentMethodService {

  // Teacher & Admin
  getAllPayments():Observable<any[]> {
    return of([
      {id: 1, name: 'KBZ PAY'},
      {id: 2, name: 'WAVE MONEY'},
      {id: 3, name: 'AYA PAY'}
    ])
  }

  // Admin
  save(value: any):Observable<any> {
    const {id, ... form} = value
    return id == 0 ? this.create(form) : this.update(id, form)
  }

  private create(form:any):Observable<any> {
    return of(form)
  }

  private update(id:number, form:any):Observable<any> {
    return of(form)
  }

  // Teacher
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

  findPaymentMethod(loginId:string):Observable<any[]> {
    return of([
      {id: 1, email: 'teacher@gmail.com', type: {id: 2, name: 'WAVE MONEY'}, accountName: 'Min Lwin', accountNumber: '09782003098'},
      {id: 2, email: 'teacher@gmail.com', type: {id: 1, name: 'KBZ PAY'}, accountName: 'Min Lwin', accountNumber: '09782003098'},
      {id: 3, email: 'teacher@gmail.com', type: {id: 3, name: 'AYA PAY'}, accountName: 'Min Lwin', accountNumber: '09782003098'},
    ])
  }

}
