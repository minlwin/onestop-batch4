import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-payment-methods',
  templateUrl: './payment-methods.component.html',
  styles: [
  ]
})
export class PaymentMethodsComponent {

  @Input()
  data:any[] = []

  @Output()
  editHandler = new EventEmitter

  edit(data:any) {
    this.editHandler.emit(data)
  }

  addNew() {
    this.editHandler.emit({})
  }
}
