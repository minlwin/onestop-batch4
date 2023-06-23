import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from 'src/app/services/apis/course.service';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './course-edit.component.html',
  styles: [
  ]
})
export class CourseEditComponent {

  form:FormGroup

  constructor(
    private builder:FormBuilder,
    route:ActivatedRoute,
    security:SecurityService,
    private router:Router,
    private courseService: CourseService) {
    this.form = builder.group({
      id: 0,
      name: ['', Validators.required],
      category: ['', Validators.required],
      description: ['', Validators.required],
      image: '',
      hours: [0, Validators.min(10)],
      fees: [0, Validators.required],
      teacher: security.loginId,
      objectives: builder.array([])
    })

    this.addObjective()

    route.queryParamMap.subscribe(map => {
      let courseId = map.get('courseId')

      if(courseId) {
        let id = Number.parseInt(courseId)
        courseService.findCourseDetails(id).subscribe(result => {
          const {teacher, category, ... others} = result

          this.form.patchValue(others)
          this.form.patchValue({category: category.name})
        })

        courseService.findObjectivesForCourse(id).subscribe(result => this.setObjectives(result))
      }
    })
  }

  save() {
    if(this.form.valid) {
      this.courseService.save(this.form.value).subscribe(result => {
        this.router.navigate(['/teacher', 'course-details'], {queryParams: {id: result.id}})
      })
    }
  }

  addObjective() {
    this.objectives.push(this.builder.control('', Validators.required))
  }

  removeObjective(index:number) {
    this.objectives.removeAt(index)

    if(this.objectives.length == 0) {
      this.addObjective()
    }
  }

  uploadPhoto() {

  }

  get objectives() {
    return this.form.get('objectives') as FormArray
  }

  private setObjectives(array:string[]) {
    this.objectives.clear()
    if(array) {
      for(let item of array) {
        this.objectives.push(this.builder.control(item, [Validators.required]))
      }
    }
  }
}
