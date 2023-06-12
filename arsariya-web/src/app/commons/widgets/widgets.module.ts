import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseItemComponent } from './course-item/course-item.component';
import { FormGroupComponent } from './form-group/form-group.component';
import { SearchTableComponent } from './search-table/search-table.component';
import { MainPageComponent } from './main-page/main-page.component';
import { FormGroupSimpleComponent } from './form-group-simple/form-group-simple.component';
import { PaginationComponent } from './pagination/pagination.component';



@NgModule({
  declarations: [
    CourseItemComponent,
    MainPageComponent,
    SearchTableComponent,
    FormGroupComponent,
    FormGroupSimpleComponent,
    PaginationComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    CourseItemComponent,
    MainPageComponent,
    SearchTableComponent,
    FormGroupComponent,
    FormGroupSimpleComponent,
    PaginationComponent
  ]
})
export class WidgetsModule { }
