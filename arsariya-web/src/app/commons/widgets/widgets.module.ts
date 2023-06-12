import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseItemComponent } from './course-item/course-item.component';
import { FormGroupComponent } from './form-group/form-group.component';



@NgModule({
  declarations: [
    CourseItemComponent,
    FormGroupComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    CourseItemComponent,
    FormGroupComponent
  ]
})
export class WidgetsModule { }
