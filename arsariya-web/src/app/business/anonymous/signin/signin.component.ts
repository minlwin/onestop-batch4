import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './signin.component.html',
  styles: [
  ]
})
export class SigninComponent {

  form:FormGroup

  constructor(
    builder:FormBuilder,
    private sercurity:SecurityService,
    private router:Router) {
    this.form = builder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.min(4)]]
    })
  }

  signIn() {
    if(this.form.valid) {
      this.sercurity.signIn(this.form.value).subscribe(result => {
        if(result) {
          this.router.navigate(['/', result.role.toLocaleLowerCase() ])
        }
      })
    }
  }
}
