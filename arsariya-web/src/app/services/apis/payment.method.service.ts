import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";

@Injectable({providedIn: 'any'})
export class PaymentMethodService {

  getAllPayments():Observable<any[]> {
    return of([
      {id: 1, name: 'KBZ PAY'},
      {id: 2, name: 'WAVE MONEY'},
      {id: 3, name: 'AYA PAY'}
    ])
  }

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
