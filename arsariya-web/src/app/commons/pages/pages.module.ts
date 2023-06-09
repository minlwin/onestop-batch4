import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseDetailsComponent } from './course-details/course-details.component';
import { TeacherProfileComponent } from './teacher-profile/teacher-profile.component';



@NgModule({
  declarations: [
    CourseDetailsComponent,
    TeacherProfileComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    CourseDetailsComponent,
    TeacherProfileComponent
  ]
})
export class PagesModule { }
