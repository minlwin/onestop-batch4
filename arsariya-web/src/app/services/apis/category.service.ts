import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'any'
})
export class CategoryService {

  constructor() { }

  findAll():Observable<any[]> {
    return of(
      [
        {id: 1, name: 'Computer Science'},
        {id: 2, name: 'Japanese Language'},
        {id: 3, name: 'ICGSE O Level'},
      ]
    )
  }

}
