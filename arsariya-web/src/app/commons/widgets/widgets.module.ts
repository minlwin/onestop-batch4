import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseItemComponent } from './course-item/course-item.component';
import { FormGroupComponent } from './form-group/form-group.component';
import { SearchTableComponent } from './search-table/search-table.component';
import { MainPageComponent } from './main-page/main-page.component';
import { FormGroupSimpleComponent } from './form-group-simple/form-group-simple.component';
import { PaginationComponent } from './pagination/pagination.component';
import { MemberProfileComponent } from './member-profile/member-profile.component';
import { ModalDialogComponent } from './modal-dialog/modal-dialog.component';
import { ErrorDialogComponent } from './error-dialog/error-dialog.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    CourseItemComponent,
    MainPageComponent,
    SearchTableComponent,
    FormGroupComponent,
    FormGroupSimpleComponent,
    PaginationComponent,
    MemberProfileComponent,
    ModalDialogComponent,
    ErrorDialogComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  exports: [
    CourseItemComponent,
    MainPageComponent,
    SearchTableComponent,
    FormGroupComponent,
    FormGroupSimpleComponent,
    PaginationComponent,
    MemberProfileComponent,
    ModalDialogComponent,
    ErrorDialogComponent
  ]
})
export class WidgetsModule { }
