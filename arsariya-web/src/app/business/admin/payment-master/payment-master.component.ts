import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ModalDialogComponent } from 'src/app/commons/widgets/modal-dialog/modal-dialog.component';
import { PaymentTypeService } from 'src/app/services/apis/payment.type.service';

@Component({
  templateUrl: './payment-master.component.html',
  styles: [
  ]
})
export class PaymentMasterComponent {

  form:FormGroup
  list:any[] = []

  @ViewChild(ModalDialogComponent)
  dialog?:ModalDialogComponent

  constructor(builder:FormBuilder, private service:PaymentTypeService) {
    this.form = builder.group({
      id: 0,
      name: ['', Validators.required]
    })

    this.search()
  }

  search() {
    this.service.getAllPayments().subscribe(result => {
      this.list = result
    })
  }

  edit(data:any) {
    this.form.patchValue(data)
    this.dialog?.show()
  }

  addNew() {
    this.form.patchValue({id: 0, name: ''})
    this.dialog?.show()
  }

  save() {
    if(this.form.valid) {
      this.service.save(this.form.value).subscribe(_ => {
        this.dialog?.hide()
        this.search()
      })
    }
  }
}
