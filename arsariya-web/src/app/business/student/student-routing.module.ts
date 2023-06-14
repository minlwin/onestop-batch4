import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student.component';
import { PublicHomeComponent } from 'src/app/commons/pages/public-home/public-home.component';
import { StudentHomeComponent } from './student-home/student-home.component';
import { CourseDetailsComponent } from 'src/app/commons/pages/course-details/course-details.component';

const routes: Routes = [
  {path: '', component: StudentComponent, children: [
    {path: 'public', component: PublicHomeComponent},
    {path: 'course-details', component: CourseDetailsComponent},
    {path: 'home', component: StudentHomeComponent},
    {path: '', redirectTo: '/student/home', pathMatch: 'full'}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
