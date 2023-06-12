import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseDetailsComponent } from './course-details/course-details.component';
import { TeacherProfileComponent } from './teacher-profile/teacher-profile.component';
import { PublicHomeComponent } from './public-home/public-home.component';
import { WidgetsModule } from '../widgets/widgets.module';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    CourseDetailsComponent,
    TeacherProfileComponent,
    PublicHomeComponent
  ],
  imports: [
    CommonModule,
    WidgetsModule,
    ReactiveFormsModule
  ],
  exports: [
    CourseDetailsComponent,
    TeacherProfileComponent,
    PublicHomeComponent
  ]
})
export class PagesModule { }
