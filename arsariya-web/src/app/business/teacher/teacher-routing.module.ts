import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TeacherComponent } from './teacher.component';
import { PublicHomeComponent } from 'src/app/commons/pages/public-home/public-home.component';
import { TeacherHomeComponent } from './teacher-home/teacher-home.component';
import { CourseEditComponent } from './course-edit/course-edit.component';
import { TeacherCourseComponent } from './teacher-course/teacher-course.component';

const routes: Routes = [
  {path: '', component: TeacherComponent, children: [
    {path: 'public', component: PublicHomeComponent},
    {path: 'home', component: TeacherHomeComponent},
    {path: 'course-edit', component: CourseEditComponent},
    {path: 'course-details', component: TeacherCourseComponent},
    {path: '', redirectTo: '/teacher/home', pathMatch: 'full'}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TeacherRoutingModule { }
