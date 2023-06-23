import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/apis/category.service';
import { CourseService } from 'src/app/services/apis/course.service';
import { Pager } from 'src/app/services/dto/api-result';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './public-home.component.html',
  styles: [
  ]
})
export class PublicHomeComponent implements OnInit {

  categories:any[] = []
  courseList:any[] = []

  mouseOn = false

  searchForm:FormGroup
  pager?:Pager
  sizes:number[] = [10, 25, 50]

  constructor(
    builder:FormBuilder,
    private router:Router,
    private security:SecurityService,
    private categoryService:CategoryService,
    private courseService:CourseService) {

    this.searchForm = builder.group({
      category: 0,
      keyword: '',
      current: 0,
      size: this.sizes[0]
    })

  }

  ngOnInit(): void {
    this.categoryService.findAll().subscribe(result => {
      this.categories = result
    })

    this.search()
  }

  search() {
    this.courseService.search(this.searchForm.value).subscribe(result => {
      this.courseList = result.list
      this.pager = result.pager
    })
  }

  searchAllCategory() {
    this.searchForm.patchValue({category: 0})
    this.search()
  }

  searchByCategory(id:number) {
    this.searchForm.patchValue({category: id})
    this.search()
  }

  showDetails(id:number) {
    this.router.navigate([`/${this.security.role.toLocaleLowerCase()}`,'course-details'], {queryParams: {id: id}})
  }

  changePage(page:number) {
    this.searchForm.patchValue({current: page})
    this.search()
  }

  changePageSize(size:number) {
    this.searchForm.patchValue({size: size, current: 0})
    this.search()
  }
}
