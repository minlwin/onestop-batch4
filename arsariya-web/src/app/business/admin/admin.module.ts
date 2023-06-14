import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { TeachersComponent } from './teachers/teachers.component';
import { StudentsComponent } from './students/students.component';
import { CoursesComponent } from './courses/courses.component';
import { RegistrationsComponent } from './registrations/registrations.component';
import { HomeComponent } from './home/home.component';
import { WidgetsModule } from 'src/app/commons/widgets/widgets.module';
import { PagesModule } from 'src/app/commons/pages/pages.module';
import { ReactiveFormsModule } from '@angular/forms';
import { PaymentMasterComponent } from './payment-master/payment-master.component';


@NgModule({
  declarations: [
    AdminComponent,
    TeachersComponent,
    StudentsComponent,
    CoursesComponent,
    RegistrationsComponent,
    HomeComponent,
    PaymentMasterComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    WidgetsModule,
    PagesModule
  ]
})
export class AdminModule { }
