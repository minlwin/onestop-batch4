import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

const DOMAIN = `${environment.baseUrl}/teacher/payment`

@Injectable({providedIn: 'any'})
export class PaymentMethodService {

  constructor(private http:HttpClient) {}

  // Teacher
  savePaymentMethod(form: any):Observable<any> {
    const {id, ... other} = form
    return id ? this.udpatePaymentMethod(id, other) : this.createPaymentMethod(other)
  }

  private createPaymentMethod(form:any):Observable<any> {
    return this.http.post<any>(DOMAIN, form)
  }

  private udpatePaymentMethod(id:number, form:any) {
    return this.http.put<any>(`${DOMAIN}/${id}`, form)
  }

  getOwnPayments():Observable<any[]> {
    return this.http.get<any[]>(DOMAIN)
  }

}
