import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ApiResult } from '../dto/api-result';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

const ADMIN_DOMAIN = `${environment.baseUrl}/admin/course`
const PUBLIC_DOMAIN = `${environment.baseUrl}/public/course`
const TEACHER_DOMAIN = `${environment.baseUrl}/teacher/course`
const STUDENT_DOMAIN = `${environment.baseUrl}/student/course`

@Injectable({
  providedIn: 'any'
})
export class CourseService {

  constructor(private http:HttpClient) { }

  // Admin
  searchForAdmin(form:any):Observable<ApiResult> {
    return this.http.get<ApiResult>(ADMIN_DOMAIN, {params: form})
  }

  // Public
  searchByCategory(id: number):Observable<any[]> {
    return this.search({category: id})
  }

  search(form: any):Observable<any[]> {
    return this.http.get<any[]>(PUBLIC_DOMAIN, {params: form})
  }

  findObjectivesForCourse(courseId:number) {
    return this.http.get<string[]>(`${PUBLIC_DOMAIN}/${courseId}/objectives`)
  }

  findCourseDetails(id: number):Observable<any> {
    return this.http.get<any>(`${PUBLIC_DOMAIN}/${id}`)
  }

  // Teacher
  save(value: any) {
    const {id, ... form} = value
    return id == 0 ? this.create(form) : this.update(id, form)
  }

  private create(form:any) {
    return this.findCourseDetails(1)
  }

  private update(id:number, form:any) {
    return this.findCourseDetails(1)
  }

  findCourseForTeacher(loginId:string) {
    return of(COURSES)
  }

  // Student
  searchCourseForStudent(loginId:string):Observable<any[]> {
    return of(COURSES)
  }

}

export const OBJECTIVES:string[] = [
  'You will learn how to leverage the power of Java to solve tasks.',
  'You will build games and programs that use Java libraries.',
  'You will be able to use Java for your own work problems or personal projects.',
  'You will create a portfolio of Java based projects you can share.',
  'Learn to use Java professionally, learning up to Java 17!',
  'Learn advanced Java features, like the collections module and how to work with timestamps!',
  'Learn to use Object Oriented Programming with classes!',
  'Understand complex topics, like threads and concurrency.',
  'Build a complete understanding of Java from the ground up!'
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
