import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from 'src/app/services/apis/course.service';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './teacher-profile.component.html',
  styles: [
  ]
})
export class TeacherProfileComponent {

  teacherEmail?:string
  courses:any[] = []

  constructor(
    route:ActivatedRoute,
    private router:Router,
    courseService:CourseService,
    private security:SecurityService) {
    route.queryParamMap.subscribe(map => {

      this.teacherEmail = map.get('teacher') ?? undefined

      if(!this.teacherEmail) {
        if(security.role == 'Teacher') {
          this.teacherEmail = security.loginId
        }
      }

      if(this.teacherEmail) {
        courseService.findCourseForTeacher(this.teacherEmail).subscribe(result => {
          this.courses = result
        })
      }
  })
  }

  get isOwnProfile() {
    return this.security.role != 'Anonymous' && this.security.loginId == this.teacherEmail
  }

  showCourseDetails(id:number) {
    this.router.navigate([`/${this.security.role.toLocaleLowerCase()}`, 'course-details'], {
      queryParams: {id: id}
    })
  }

}
