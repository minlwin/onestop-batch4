import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router } from '@angular/router';
import { CourseService } from 'src/app/services/apis/course.service';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  selector: 'app-course-cover',
  templateUrl: './course-cover.component.html',
  styles: [
  ]
})
export class CourseCoverComponent {

  @Input()
  dto:any

  @Input()
  hideControls?:boolean

  @Output()
  onFileUpload = new EventEmitter

  constructor(private security:SecurityService, private router:Router) {}

  takeRegistration() {
    if(this.security.role == 'Anonymous') {
      this.router.navigate(['/anonymous', 'registration'], {queryParams: {courseId: this.dto.id}})
    } else if (this.security.role == 'Student') {
      this.router.navigate(['/student', 'paid'], {queryParams: {courseId: this.dto.id}})
    } else {
      throw({message: `${this.security.role} User can not register to the course.`, type: 'Business'})
    }
  }

  goToClassRoom() {
    if(this.dto.type == 'OWN_COURSE' || this.dto.type == 'ATTEND_COURSE') {
      this.router.navigate([this.rootSegment, 'class-room'], {queryParams: {courseId: this.dto.id}})
    }
  }

  editCourse() {
    if(this.dto.type == 'OWN_COURSE') {
      this.router.navigate(['/teacher', 'course-edit'], {queryParams: {courseId: this.dto.id}})
    }
  }

  get rootSegment() {
    return `/${this.security.role.toLocaleLowerCase()}`
  }

  uploadImage(files:FileList | null) {
    if(files) {
      this.onFileUpload.emit(files[0])
    }
  }

}
