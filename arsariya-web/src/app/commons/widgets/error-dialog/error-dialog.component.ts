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

  message?:string | string []
  logout?:boolean

  constructor(private security:SecurityService, private router:Router) {}

  @ViewChild(ModalDialogComponent)
  dialog?:ModalDialogComponent

  get messages():string[] {
    return this.message as string[] ?? []
  }

  show(message:string | string [], type?:string) {
    this.message = message
    this.logout = type == 'Auth'
    this.dialog?.show()
  }

  close() {
    this.dialog?.hide()
  }

  closeAndLogout() {
    this.security.signOut()
    this.router.navigate(['/anonymous', 'signin'])
    this.dialog?.hide()
  }
}
