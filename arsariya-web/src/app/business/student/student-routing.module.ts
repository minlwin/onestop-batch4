import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student.component';
import { PublicHomeComponent } from 'src/app/commons/pages/public-home/public-home.component';
import { StudentHomeComponent } from './student-home/student-home.component';
import { CourseDetailsComponent } from 'src/app/commons/pages/course-details/course-details.component';
import { TeacherProfileComponent } from 'src/app/commons/pages/teacher-profile/teacher-profile.component';
import { RegistrationPaidComponent } from './registration-paid/registration-paid.component';
import { StudentClassRoomComponent } from './student-class-room/student-class-room.component';

const routes: Routes = [
  {path: '', component: StudentComponent, children: [
    {path: 'public', component: PublicHomeComponent},
    {path: 'course-details', component: CourseDetailsComponent},
    {path: 'teacher-profile', component: TeacherProfileComponent},
    {path: 'class-room', component: StudentClassRoomComponent, children: [

    ]},
    {path: 'paid', component: RegistrationPaidComponent},
    {path: 'home', component: StudentHomeComponent},
    {path: '', redirectTo: '/student/home', pathMatch: 'full'}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
