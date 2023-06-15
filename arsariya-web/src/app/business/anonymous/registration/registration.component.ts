import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from 'src/app/services/apis/course.service';
import { BusinessException } from 'src/app/services/dto/business-exception';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './registration.component.html',
  styles: [
  ]
})
export class RegistrationComponent {

  form:FormGroup
  course:any

  constructor(builder:FormBuilder,
    route:ActivatedRoute,
    private security:SecurityService,
    courseService:CourseService,
    private router:Router) {
    this.form = builder.group({
      name: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    })

    route.queryParamMap.subscribe(map => {
      let courseId = map.get('courseId')
      if(!courseId) {
        throw new BusinessException('Course ID is required for registration.')
      }

      courseService.findCourseDetails(Number.parseInt(courseId)).subscribe(result => {
        this.course = result
      })

    })
  }

  register() {
    if(this.form.valid) {
      this.security.studentSignUp(this.form.value).subscribe(_ => {
        this.router.navigate(['/student', 'paid'], {queryParams: {courseId: this.course.id}})
      })
    }
  }
}
