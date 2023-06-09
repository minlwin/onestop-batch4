import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseItemComponent } from './course-item/course-item.component';



@NgModule({
  declarations: [
    CourseItemComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    CourseItemComponent
  ]
})
export class WidgetsModule { }
