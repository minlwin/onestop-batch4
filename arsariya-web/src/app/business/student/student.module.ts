import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import { StudentComponent } from './student.component';
import { StudentHomeComponent } from './student-home/student-home.component';
import { PagesModule } from 'src/app/commons/pages/pages.module';
import { WidgetsModule } from 'src/app/commons/widgets/widgets.module';
import { RegistrationPaidComponent } from './registration-paid/registration-paid.component';


@NgModule({
  declarations: [
    StudentComponent,
    StudentHomeComponent,
    RegistrationPaidComponent
  ],
  imports: [
    CommonModule,
    StudentRoutingModule,
    PagesModule,
    WidgetsModule
  ]
})
export class StudentModule { }
