import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { HomeComponent } from './home/home.component';
import { TeachersComponent } from './teachers/teachers.component';
import { StudentsComponent } from './students/students.component';
import { CoursesComponent } from './courses/courses.component';
import { RegistrationsComponent } from './registrations/registrations.component';
import { PublicHomeComponent } from 'src/app/commons/pages/public-home/public-home.component';
import { PaymentMasterComponent } from './payment-master/payment-master.component';
import { CourseDetailsComponent } from 'src/app/commons/pages/course-details/course-details.component';
import { TeacherProfileComponent } from 'src/app/commons/pages/teacher-profile/teacher-profile.component';

const routes: Routes = [
  {path: '', component: AdminComponent, children: [
    {path: 'public', component: PublicHomeComponent},
    {path: 'course-details', component: CourseDetailsComponent},
    {path: 'teacher-profile', component: TeacherProfileComponent},
    {path: 'payment', component: PaymentMasterComponent},
    {path: 'teachers', component: TeachersComponent},
    {path: 'students', component: StudentsComponent},
    {path: 'courses', component: CoursesComponent},
    {path: 'registrations', component: RegistrationsComponent},
    {path: 'home', component: HomeComponent},
    {path: '', redirectTo: '/admin/home', pathMatch: 'full'}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
