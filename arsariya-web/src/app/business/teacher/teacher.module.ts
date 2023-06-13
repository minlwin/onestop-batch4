import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TeacherRoutingModule } from './teacher-routing.module';
import { TeacherComponent } from './teacher.component';
import { TeacherCourseComponent } from './teacher-course/teacher-course.component';
import { CourseEditComponent } from './course-edit/course-edit.component';
import { TeacherHomeComponent } from './teacher-home/teacher-home.component';
import { WidgetsModule } from 'src/app/commons/widgets/widgets.module';
import { PagesModule } from 'src/app/commons/pages/pages.module';
import { PaymentMethodsComponent } from './teacher-home/payment-methods/payment-methods.component';


@NgModule({
  declarations: [
    TeacherComponent,
    TeacherCourseComponent,
    CourseEditComponent,
    TeacherHomeComponent,
    PaymentMethodsComponent
  ],
  imports: [
    CommonModule,
    TeacherRoutingModule,
    WidgetsModule,
    PagesModule
  ]
})
export class TeacherModule { }
