import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { SecurityService } from "src/app/services/security/security.service";

@Component({
  templateUrl: './teacher.component.html'
})
export class TeacherComponent {

  constructor(private security:SecurityService, private router:Router) {}

  signOut() {
    this.security.signOut()
    this.router.navigate(['/anonymous'])
  }

  get loginId() {
    return this.security.loginId
  }

}
