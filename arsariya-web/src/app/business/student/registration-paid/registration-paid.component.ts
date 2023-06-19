import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from 'src/app/services/apis/course.service';
import { PaymentMethodService } from 'src/app/services/apis/payment.method.service';
import { PaymentTypeService } from 'src/app/services/apis/payment.type.service';
import { RegistrationService } from 'src/app/services/apis/registration.service';
import { BusinessException } from 'src/app/services/dto/business-exception';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './registration-paid.component.html',
  styles: [
  ]
})
export class RegistrationPaidComponent {

  course:any
  form:FormGroup
  studentName?:string

  payments:any[] = []

  constructor(
    route:ActivatedRoute,
    courseService:CourseService,
    builder:FormBuilder,
    security:SecurityService,
    paymentService:PaymentTypeService,
    private router:Router,
    private registrationService:RegistrationService) {

    this.form = builder.group({
      courseId: 0,
      studentId: security.loginId,
      paymentId: [0, Validators.min(1)],
      fees: 0,
      promotionCode: ''
    })

    this.studentName = security.loginUserName

    route.queryParamMap.subscribe(map => {
      let courseId = map.get('courseId')

      if(!courseId) {
        throw new BusinessException('Course ID is required for registration.')
      }

      const id = Number.parseInt(courseId)
      courseService.findCourseDetails(id).subscribe(result => {
        this.course = result
        this.form.patchValue({courseId: id, fees: result.fees})
      })

    })

    paymentService.getAllPayments().subscribe(result => {
      this.payments = result
    })
  }

  purchase() {
    if(this.form.valid) {
      this.registrationService.purchaseCourse(this.form.value).subscribe(_ => {
        this.router.navigate(['/student'])
      })
    }
  }
}
