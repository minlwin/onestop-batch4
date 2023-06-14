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
}
