import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ApiResult } from '../dto/api-result';

@Injectable({
  providedIn: 'any'
})
export class CourseService {

  constructor() { }

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

  searchByCategory(id: number):Observable<any[]> {
    return this.search({category: id})
  }

  search(form: any):Observable<any[]> {
    return of(this.result)
  }

  private result:any[] = [
    {
      id: 1,
      name: 'Java Basic',
      category: {
        id: 1,
        name: 'Computer Science'
      },
      description: 'Entry course of Java Programming. Basic of the basic.',
      teacher: {
        id: 1,
        name: 'Mr Hank'
      }
    },
    {
      id: 1,
      name: 'Java Basic',
      category: {
        id: 1,
        name: 'Computer Science'
      },
      description: 'Entry course of Java Programming. Basic of the basic.',
      teacher: {
        id: 1,
        name: 'Mr Hank'
      }
    },
    {
      id: 1,
      name: 'Java Basic',
      category: {
        id: 1,
        name: 'Computer Science'
      },
      description: 'Entry course of Java Programming. Basic of the basic.',
      teacher: {
        id: 1,
        name: 'Mr Hank'
      }
    },
    {
      id: 1,
      name: 'Java Basic',
      category: {
        id: 1,
        name: 'Computer Science'
      },
      description: 'Entry course of Java Programming. Basic of the basic.',
      teacher: {
        id: 1,
        name: 'Mr Hank'
      }
    },

  ]

}
