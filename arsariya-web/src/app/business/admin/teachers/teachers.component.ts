import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { TeacherService } from 'src/app/services/apis/teacher.service';
import { ListResult, Pager } from 'src/app/services/dto/api-result';
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
      student: '',
      email: '',
      phone: '',
      current: 1,
      size: this.sizes[0]
    })
  }

  search() {
    this.service.searchForAdmin(this.form.value).subscribe(result => {
      let listResult = result.result as ListResult
      this.list = listResult.list
      this.pager = listResult.pager
    })
  }

}
