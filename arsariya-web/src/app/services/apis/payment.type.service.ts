import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

const ADMIN_DOMAIN = `${environment.baseUrl}/admin/payment`
const MEMBER_DOMAIN = `${environment.baseUrl}/member/payment`

@Injectable({providedIn: 'any'})
export class PaymentTypeService {

  constructor(private http:HttpClient) {}

    // Teacher & Admin
    getAllPayments():Observable<any[]> {
      return this.http.get<any[]>(MEMBER_DOMAIN)
    }

    // Admin
    save(value: any):Observable<any> {
      const {id, ... form} = value
      return id == 0 ? this.create(form) : this.update(id, form)
    }

    private create(form:any):Observable<any> {
      return this.http.post(ADMIN_DOMAIN, form)
    }

    private update(id:number, form:any):Observable<any> {
      return this.http.put(`${ADMIN_DOMAIN}/${id}`, form)
    }
}
