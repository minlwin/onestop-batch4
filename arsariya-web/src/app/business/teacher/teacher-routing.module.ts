import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TeacherComponent } from './teacher.component';
import { PublicHomeComponent } from 'src/app/commons/pages/public-home/public-home.component';
import { CourseEditComponent } from './course-edit/course-edit.component';
import { CourseDetailsComponent } from 'src/app/commons/pages/course-details/course-details.component';
import { TeacherProfileComponent } from 'src/app/commons/pages/teacher-profile/teacher-profile.component';
import { TeacherClassRoomComponent } from './teacher-class-room/teacher-class-room.component';

const routes: Routes = [
  {path: '', component: TeacherComponent, children: [
    {path: 'public', component: PublicHomeComponent},
    {path: 'home', component: TeacherProfileComponent},
    {path: 'course-edit', component: CourseEditComponent},
    {path: 'course-details', component: CourseDetailsComponent},
    {path: 'class-room', component: TeacherClassRoomComponent},
    {path: 'teacher-profile', component: TeacherProfileComponent},
    {path: '', redirectTo: '/teacher/home', pathMatch: 'full'}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TeacherRoutingModule { }
