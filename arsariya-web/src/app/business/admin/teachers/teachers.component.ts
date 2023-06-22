import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { TeacherService } from 'src/app/services/apis/teacher.service';
import { Pager } from 'src/app/services/dto/api-result';
import { PagerListComponent } from '../pager-list.component';

@Component({
  templateUrl: './teachers.component.html',
  styles: [
  ]
})
export class TeachersComponent extends PagerListComponent{

  form:FormGroup
  list:any[] = []
  pager?:Pager

  constructor(builder:FormBuilder, private service:TeacherService) {
    super();
    this.form = builder.group({
      teacher: '',
      email: '',
      phone: '',
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
