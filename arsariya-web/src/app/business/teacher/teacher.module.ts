import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TeacherRoutingModule } from './teacher-routing.module';
import { TeacherComponent } from './teacher.component';
import { CourseEditComponent } from './course-edit/course-edit.component';
import { WidgetsModule } from 'src/app/commons/widgets/widgets.module';
import { PagesModule } from 'src/app/commons/pages/pages.module';
import { ReactiveFormsModule } from '@angular/forms';
import { TeacherClassRoomComponent } from './teacher-class-room/teacher-class-room.component';


@NgModule({
  declarations: [
    TeacherComponent,
    CourseEditComponent,
    TeacherClassRoomComponent,
  ],
  imports: [
    CommonModule,
    TeacherRoutingModule,
    WidgetsModule,
    PagesModule,
    ReactiveFormsModule
  ]
})
export class TeacherModule { }
