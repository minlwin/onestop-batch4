import { Component, Input, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ModalDialogComponent } from 'src/app/commons/widgets/modal-dialog/modal-dialog.component';
import { PaymentMethodService } from 'src/app/services/apis/payment.method.service';
import { TeacherService } from 'src/app/services/apis/teacher.service';

@Component({
  selector: 'app-payment-method',
  templateUrl: './payment-method.component.html',
  styles: [
  ]
})
export class PaymentMethodComponent {
  @Input()
  email?:string

  data:any[] = []

  payments:any[] = []

  @ViewChild(ModalDialogComponent)
  modalDialog?:ModalDialogComponent

  form:FormGroup

  constructor(builder:FormBuilder,
    private service:TeacherService,
    private paymentMethodService:PaymentMethodService) {
    this.form = builder.group({
      id: 0,
      email: ['', Validators.required],
      type: ['', Validators.required],
      accountName: ['', Validators.required],
      accountNumber: ['', Validators.required]
    })
  }

  ngOnInit(): void {

    this.paymentMethodService.getAllPayments().subscribe(result => {
      this.payments = result
    })

    this.search()
  }

  search() {
    if(this.email) {
      this.service.findPaymentMethod(this.email).subscribe(result => {
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
      })
    }
  }
}
