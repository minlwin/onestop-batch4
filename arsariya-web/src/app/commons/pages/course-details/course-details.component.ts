import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { tap } from 'rxjs';
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
        courseService.findCourseDetails(this.id)
          // Delete after using api
          .pipe(tap(data => {
            data.type = security.role == 'Student' ? 'PROMOTE' : (security.role == 'Teacher' ? 'OWN_COURSE' : (security.role == 'Anonymous' ? 'PROMOTE' : 'NONE') )
          }))
          // Delete until here
          .subscribe(result => {
          this.courseDto = result
        })
      }
    })
  }

  showCoursesForTeacher() {
    this.router.navigate([this.rootSegment, 'teacher-profile'], {queryParams: {teacher: 'teacher@gmail.com'}})
  }

  get rootSegment() {
    return `/${this.security.role.toLocaleLowerCase()}`
  }
}
