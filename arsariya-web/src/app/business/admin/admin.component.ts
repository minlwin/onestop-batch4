import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { SecurityService } from "src/app/services/security/security.service";

@Component({
  templateUrl: './admin.component.html'
})
export class AdminComponent {

  constructor(private security:SecurityService, private router:Router) {}

  signOut() {
    this.security.signOut()
    this.router.navigate(['/anonymous'])
  }
}
