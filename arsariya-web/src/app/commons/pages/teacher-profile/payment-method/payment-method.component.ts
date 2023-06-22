import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ModalDialogComponent } from 'src/app/commons/widgets/modal-dialog/modal-dialog.component';
import { PaymentMethodService } from 'src/app/services/apis/payment.method.service';
import { PaymentTypeService } from 'src/app/services/apis/payment.type.service';

@Component({
  selector: 'app-payment-method',
  templateUrl: './payment-method.component.html',
  styles: [
  ]
})
export class PaymentMethodComponent implements OnInit{

  @Input()
  email?:string

  data:any[] = []

  payments:any[] = []

  @ViewChild(ModalDialogComponent)
  modalDialog?:ModalDialogComponent

  form:FormGroup

  constructor(builder:FormBuilder,
    paymentTypeService:PaymentTypeService,
    private service:PaymentMethodService) {
    this.form = builder.group({
      id: 0,
      email: ['', Validators.required],
      type: ['', Validators.required],
      accountName: ['', Validators.required],
      accountNumber: ['', Validators.required]
    })

    paymentTypeService.getAllPayments().subscribe(result => {
      this.payments = result
    })
  }

  ngOnInit(): void {
    this.search()
  }

  search() {
    if(this.email) {
      this.service.getOwnPayments().subscribe(result => {
        this.data = result
      })
    }
  }

  edit(data:any) {
    const {type, ... other} = data
    this.form.patchValue(other)
    this.form.patchValue({type: type.id})
    this.modalDialog?.show()
  }

  addNew() {
    this.form.patchValue({
      id: 0,
      email: this.email,
      type: '',
      accountName: '',
      accountNumber: ''
    })
    this.modalDialog?.show()
  }

  save() {
    if(this.form.valid) {
      this.service.savePaymentMethod(this.form.value).subscribe(_ => {
        this.search()
        this.modalDialog?.hide()
      })
    }
  }
}
