import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseDetailsComponent } from './course-details/course-details.component';
import { TeacherProfileComponent } from './teacher-profile/teacher-profile.component';
import { PublicHomeComponent } from './public-home/public-home.component';
import { WidgetsModule } from '../widgets/widgets.module';
import { ReactiveFormsModule } from '@angular/forms';
import { CourseCoverComponent } from './course-details/course-cover/course-cover.component';
import { CourseObjectivesComponent } from './course-details/course-objectives/course-objectives.component';
import { PaymentMethodComponent } from './teacher-profile/payment-method/payment-method.component';
import { ClassRoomComponent } from './class-room/class-room.component';



@NgModule({
  declarations: [
    CourseDetailsComponent,
    TeacherProfileComponent,
    PublicHomeComponent,
    CourseCoverComponent,
    CourseObjectivesComponent,
    PaymentMethodComponent,
    ClassRoomComponent,
  ],
  imports: [
    CommonModule,
    WidgetsModule,
    ReactiveFormsModule
  ],
  exports: [
    CourseDetailsComponent,
    TeacherProfileComponent,
    PublicHomeComponent,
    ClassRoomComponent,
    CourseCoverComponent,
  ]
})
export class PagesModule { }
