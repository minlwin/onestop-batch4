import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/apis/category.service';
import { CourseService } from 'src/app/services/apis/course.service';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './public-home.component.html',
  styles: [
  ]
})
export class PublicHomeComponent implements OnInit {

  categories:any[] = []
  courseList:any[] = []
  searchForm:FormGroup

  constructor(
    builder:FormBuilder,
    private router:Router,
    private security:SecurityService,
    private categoryService:CategoryService,
    private courseService:CourseService) {

      this.searchForm = builder.group({
      keyword: ''
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
      this.courseList = result
    })
  }

  searchByCategory(id:number) {
    this.courseService.searchByCategory(id).subscribe(result => {
      this.courseList = result
    })
  }

  showDetails(id:number) {
    this.router.navigate([`/${this.security.role.toLocaleLowerCase()}`,'course-details'], {queryParams: {id: id}})
  }
}
