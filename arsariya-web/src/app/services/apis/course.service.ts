import { Injectable } from '@angular/core';
import { Observable, of, tap } from 'rxjs';
import { ApiResult } from '../dto/api-result';

@Injectable({
  providedIn: 'any'
})
export class CourseService {

  constructor() { }

  findCourseDetails(id: number):Observable<any> {
    return of(COURSES[0]).pipe(tap(data => data.fees = 120000))
  }

  searchForAdmin(form:any):Observable<ApiResult> {
    return of({
      status: 'Success',
      result: {
        list: [],
        pager: {
          current: 4,
          size: 10,
          totalCount: 51,
          totalPage: 6
        }
      }
    })
  }

  searchByCategory(id: number):Observable<any[]> {
    return this.search({category: id})
  }

  search(form: any):Observable<any[]> {
    return of(COURSES)
  }

  findObjectivesForCourse(courseId:number) {
    return of(OBJECTIVES)
  }

}

export const OBJECTIVES:any[] = [
  {id: 1, objective: 'You will learn how to leverage the power of Java to solve tasks.'},
  {id: 1, objective: 'You will build games and programs that use Java libraries.'},
  {id: 1, objective: 'You will be able to use Java for your own work problems or personal projects.'},
  {id: 1, objective: 'You will create a portfolio of Java based projects you can share.'},
  {id: 1, objective: 'Learn to use Java professionally, learning up to Java 17!'},
  {id: 1, objective: 'Learn advanced Java features, like the collections module and how to work with timestamps!'},
  {id: 1, objective: 'Learn to use Object Oriented Programming with classes!'},
  {id: 1, objective: 'Understand complex topics, like threads and concurrency.'},
  {id: 1, objective: 'Build a complete understanding of Java from the ground up!'}
]

export const COURSES:any[] = [
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
      email: 'hank@gmail.com',
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
