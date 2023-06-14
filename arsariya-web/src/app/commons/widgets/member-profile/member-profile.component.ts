import { Component, Input, OnChanges, SimpleChanges, ViewChild } from '@angular/core';
import { ProfileService } from 'src/app/services/apis/profile.service';
import { ModalDialogComponent } from '../modal-dialog/modal-dialog.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-member-profile',
  templateUrl: './member-profile.component.html',
  styles: [
  ]
})
export class MemberProfileComponent implements OnChanges{

  profile:any

  @Input()
  email?:string

  @Input()
  canEdit?:boolean

  @ViewChild(ModalDialogComponent)
  modalDialog?:ModalDialogComponent

  form:FormGroup

  constructor(builder:FormBuilder ,private service:ProfileService) {
    this.form = builder.group({
      id: 0,
      name: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', Validators.required],
      image: ''
    })
  }

  ngOnChanges(_changes: SimpleChanges): void {
    if(this.email) {
      this.service.getProfile(this.email).subscribe(result => {
        this.profile = result
        this.form.patchValue(result)
      })
    }
  }

  edit() {
    if(this.canEdit) {
      this.modalDialog?.show()
    }
  }

  save() {
    if(this.form.valid) {
      this.service.saveProfile(this.form.value).subscribe(result => {
        this.form.patchValue(result)
        this.profile = result
        this.modalDialog?.hide()
      })
    }
  }
}
