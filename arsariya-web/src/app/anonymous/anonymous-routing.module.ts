import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { RegistrationComponent } from './registration/registration.component';
import { CourseDetailsComponent } from '../commons/pages/course-details/course-details.component';
import { AnonymousComponent } from './anonymous-component';

const routes: Routes = [
  {path: '', component: AnonymousComponent, children: [
    {path: 'home', component: HomeComponent},
    {path: 'signin', component: SigninComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'registration', component: RegistrationComponent},
    {path: 'course-details', component: CourseDetailsComponent},
    {path: 'registration', component: RegistrationComponent},
    {path: '', redirectTo: '/anonymous/home', pathMatch: 'full'}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AnonymousRoutingModule { }
