import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'any'
})
export class CourseService {

  constructor() { }

  searchByCategory(id: number):Observable<any[]> {
    return of(this.result)
  }

  search(value: any):Observable<any[]> {
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
