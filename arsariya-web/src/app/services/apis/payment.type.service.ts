import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { environment } from "src/environments/environment";

const ADMIN_DOMAIN = `${environment.baseUrl}/admin/payment`
const MEMBER_DOMAIN = `${environment.baseUrl}/member/payment`

@Injectable({providedIn: 'any'})
export class PaymentTypeService {

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
}
