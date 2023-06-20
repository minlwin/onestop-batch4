import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const DOMAIN = `${environment.baseUrl}/public/category`

@Injectable({
  providedIn: 'any'
})
export class CategoryService {

  constructor(private http:HttpClient) { }

  findAll():Observable<any[]> {
    return this.http.get<any[]>(DOMAIN)
  }
}
