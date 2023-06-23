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
import { ProfileImagePipe } from './utils/pipes/profile-image.pipe';
import { HoverableDirective } from './utils/directives/hoverable.directive';
import { FocusableDirective } from './utils/directives/focusable.directive';
import { CourseImagePipe } from './utils/pipes/course-image.pipe';

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
    ErrorDialogComponent,
    HoverableDirective,
    FocusableDirective,
    ProfileImagePipe,
    CourseImagePipe,
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
    ErrorDialogComponent,
    HoverableDirective,
    FocusableDirective,
    ProfileImagePipe,
    CourseImagePipe,
  ]
})
export class WidgetsModule { }
