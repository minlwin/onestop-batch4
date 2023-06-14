import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from 'src/app/services/apis/course.service';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './course-details.component.html',
  styles: [
  ]
})
export class CourseDetailsComponent {

  id?:number

  courseDto:any

  constructor(route:ActivatedRoute,
    courseService:CourseService,
    private security:SecurityService,
    private router:Router) {
    route.queryParamMap.subscribe(map => {
      this.id = Number.parseInt(map.get('id')!)

      if(this.id) {
        // Load Course Information
        courseService.findCourseDetails(this.id).subscribe(result => {
          this.courseDto = result
        })
      }
    })
  }

  get isOwnCourse() {
    return this.security.role == 'Teacher' && this.security.loginId == this.courseDto.teacher.email
  }


  showCoursesForTeacher() {
    this.router.navigate([`/${this.security.role.toLocaleLowerCase()}`, 'teacher-profile'], {queryParams: {teacher: 'teacher@gmail.com'}})
  }
}
