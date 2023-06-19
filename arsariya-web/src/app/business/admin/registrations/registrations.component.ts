import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RegistrationService } from 'src/app/services/apis/registration.service';
import { PageResult, Pager } from 'src/app/services/dto/api-result';
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
      current: 1,
      size: this.sizes[0]
    })
  }

  search() {
    this.service.searchForAdmin(this.form.value).subscribe(result => {
      let listResult = result.result as PageResult
      this.list = listResult.list
      this.pager = listResult.pager
    })
  }
}
