import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CourseService } from 'src/app/services/apis/course.service';
import { ListResult, Pager } from 'src/app/services/dto/api-result';

@Component({
  templateUrl: './courses.component.html',
  styles: [
  ]
})
export class CoursesComponent {

  form:FormGroup
  sizes:number[] = [10, 25, 50]
  list:any[] = []
  pager?:Pager

  constructor(builder:FormBuilder, private service:CourseService) {
    this.form = builder.group({
      teacher: '',
      course: '',
      from: '',
      to: '',
      current: 1,
      size: this.sizes[0]
    })

    this.search()
  }

  search() {
    this.service.searchForAdmin(this.form.value).subscribe(result => {
      let listResult = result.result as ListResult
      this.list = listResult.list
      this.pager = listResult.pager
    })
  }

  changePage(page:number) {
    this.form.patchValue({current: page})
    this.search()
  }

  changePageSize(size:number) {
    this.form.patchValue({size: size})
    this.search()
  }
}
