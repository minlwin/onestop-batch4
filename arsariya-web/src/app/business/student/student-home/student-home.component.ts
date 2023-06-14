import { Component } from '@angular/core';
import { StudentService } from 'src/app/services/apis/student.service';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './student-home.component.html',
  styles: [
  ]
})
export class StudentHomeComponent {

  email?:string
  courses:any[] = []

  constructor(security:SecurityService, studentService:StudentService) {
    this.email = security.loginId

    studentService.searchCourseForStudent(this.email).subscribe(result => {
      this.courses = result
    })
  }
}
