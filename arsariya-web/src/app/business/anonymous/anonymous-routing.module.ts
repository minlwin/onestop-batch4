import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { RegistrationComponent } from './registration/registration.component';
import { CourseDetailsComponent } from '../../commons/pages/course-details/course-details.component';
import { AnonymousComponent } from './anonymous-component';
import { PublicHomeComponent } from 'src/app/commons/pages/public-home/public-home.component';
import { TeacherProfileComponent } from 'src/app/commons/pages/teacher-profile/teacher-profile.component';

const routes: Routes = [
  {path: '', component: AnonymousComponent, children: [
    {path: 'signin', component: SigninComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'registration', component: RegistrationComponent},
    {path: 'course-details', component: CourseDetailsComponent},
    {path: 'teacher-profile', component: TeacherProfileComponent},
    {path: '', component: PublicHomeComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AnonymousRoutingModule { }
