import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RegistrationService } from 'src/app/services/apis/registration.service';
import { Pager } from 'src/app/services/dto/api-result';
import { PagerListComponent } from '../pager-list.component';

@Component({
  templateUrl: './registrations.component.html',
  styles: [
  ]
})
export class RegistrationsComponent extends PagerListComponent{

  form:FormGroup
  list:any[] = []
  pager?:Pager

  constructor(builder:FormBuilder, private service:RegistrationService) {
    super()
    this.form = builder.group({
      student: '',
      course: '',
      from: '',
      to: '',
      current: 0,
      size: this.sizes[0]
    })

    this.search()
  }

  search() {
    this.service.searchForAdmin(this.form.value).subscribe(result => {
      this.list = result.list
      this.pager = result.pager
    })
  }
}
