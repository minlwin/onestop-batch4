import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { StudentService } from 'src/app/services/apis/student.service';
import { Pager } from 'src/app/services/dto/api-result';
import { PagerListComponent } from '../pager-list.component';

@Component({
  templateUrl: './students.component.html',
  styles: [
  ]
})
export class StudentsComponent extends PagerListComponent{

  form:FormGroup
  list:any[] = []
  pager?:Pager

  constructor(builder:FormBuilder, private service:StudentService) {
    super()
    this.form = builder.group({
      student: '',
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
