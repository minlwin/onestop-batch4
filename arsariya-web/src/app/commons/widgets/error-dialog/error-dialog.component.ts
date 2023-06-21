import { Component, ViewChild } from '@angular/core';
import { ModalDialogComponent } from '../modal-dialog/modal-dialog.component';
import { SecurityService } from 'src/app/services/security/security.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-error-dialog',
  templateUrl: './error-dialog.component.html',
  styles: [
  ]
})
export class ErrorDialogComponent {

  message?:string
  logout?:boolean

  constructor(private security:SecurityService, private router:Router) {}

  @ViewChild(ModalDialogComponent)
  dialog?:ModalDialogComponent

  show(message?:string, type?:string) {
    this.message = message
    this.logout = type == 'Auth'
    this.dialog?.show()
  }

  close() {
    this.dialog?.hide()
  }

  closeAndLogout() {
    this.security.signOut()
    this.router.navigate(['/'])
    this.dialog?.hide()
  }
}
