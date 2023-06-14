import { Component, Input, OnInit } from '@angular/core';
import { CourseService } from 'src/app/services/apis/course.service';

@Component({
  selector: 'app-course-objectives',
  templateUrl: './course-objectives.component.html',
  styles: [
  ]
})
export class CourseObjectivesComponent implements OnInit{

  @Input()
  courseId?:number

  list:any[] = []

  constructor(private service:CourseService) {

  }

  ngOnInit(): void {
    this.service.findObjectivesForCourse(this.courseId ?? 1).subscribe(result => {
      this.list = result
    })
  }

}
