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

  email?:string
  courses:any[] = []

  constructor(
    private security:SecurityService,
    private teacherService:TeacherService) {}

  ngOnInit(): void {
    this.email = this.security.loginId

    this.teacherService.findCourseForTeacher(this.security.loginId).subscribe(result => {
      this.courses = result
    })
  }
}
