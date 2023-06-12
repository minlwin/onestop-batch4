import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AnonymousRoutingModule } from './anonymous-routing.module';
import { AnonymousComponent } from './anonymous-component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { RegistrationComponent } from './registration/registration.component';
import { PagesModule } from '../../commons/pages/pages.module';
import { ReactiveFormsModule } from '@angular/forms';
import { WidgetsModule } from '../../commons/widgets/widgets.module';

@NgModule({
  declarations: [
    AnonymousComponent,
    SigninComponent,
    SignupComponent,
    RegistrationComponent
  ],
  imports: [
    CommonModule,
    AnonymousRoutingModule,
    PagesModule,
    WidgetsModule,
    ReactiveFormsModule
  ]
})
export class AnonymousModule { }
