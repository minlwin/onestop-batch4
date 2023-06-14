import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './signup.component.html',
  styles: [
  ]
})
export class SignupComponent {

  form:FormGroup

  constructor(builder:FormBuilder, private security:SecurityService, private router:Router) {
    this.form = builder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.min(4)]]
    })
  }

  signUp() {
    if(this.form.valid) {
      this.security.teacherSignUp(this.form.value).subscribe(_ => {
        this.router.navigate(['/teacher'])
      })
    }
  }
}
