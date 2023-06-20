import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
    return this.http.post<any>(TEACHER_DOMAIN, form)
  }

  private update(id:number, form:any) {
    return this.http.put<any>(`${TEACHER_DOMAIN}/${id}`, form)
  }

  findCourseForTeacher(loginId:string) {
    return this.http.get<any[]>(TEACHER_DOMAIN, {params: {loginId: loginId}})
  }

  // Student
  searchCourseForStudent(loginId:string):Observable<any[]> {
    return this.http.get<any[]>(STUDENT_DOMAIN, {params: {loginId: loginId}})
  }

}
