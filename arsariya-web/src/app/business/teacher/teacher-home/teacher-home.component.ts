import { Component, OnInit } from '@angular/core';
import { ProfileService } from 'src/app/services/apis/profile.service';
import { TeacherService } from 'src/app/services/apis/teacher.service';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './teacher-home.component.html',
  styles: [
  ]
})
export class TeacherHomeComponent implements OnInit{

  profile:any
  payments:any[] = []
  courses:any[] = []

  constructor(
    private security:SecurityService,
    private profleService:ProfileService,
    private teacherService:TeacherService) {}

  ngOnInit(): void {
    this.profleService.getProfile(this.security.loginId).subscribe(result => {
      this.profile = result
    })

    this.teacherService.findPaymentMethod(this.security.loginId).subscribe(result => {
      this.payments = result
    })

    this.teacherService.findCourseForTeacher(this.security.loginId).subscribe(result => {
      this.courses = result
    })
  }
}
