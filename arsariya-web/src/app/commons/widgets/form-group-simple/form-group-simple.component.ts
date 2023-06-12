import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-form-group-simple',
  templateUrl: './form-group-simple.component.html',
  styles: [
  ]
})
export class FormGroupSimpleComponent {

  @Input()
  label?:string


}
