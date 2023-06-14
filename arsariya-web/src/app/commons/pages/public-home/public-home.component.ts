import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/apis/category.service';
import { CourseService } from 'src/app/services/apis/course.service';

@Component({
  templateUrl: './public-home.component.html',
  styles: [
  ]
})
export class PublicHomeComponent implements OnInit {

  categories:any[] = []
  courseList:any[] = []
  searchForm:FormGroup

  viewType?:string

  constructor(
    builder:FormBuilder,
    route:ActivatedRoute,
    private router:Router,
    private categoryService:CategoryService,
    private courseService:CourseService) {

      this.searchForm = builder.group({
      keyword: ''
    })

    route.queryParamMap.subscribe(map => {
      let type = map.get('type')
      if(type) {
        this.viewType = type
      }
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
    this.router.navigate([`/${this.viewType || 'anonymous'}`,'course-details'], {queryParams: {id: id}})
  }
}
