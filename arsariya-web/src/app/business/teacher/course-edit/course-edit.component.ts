import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CourseService } from 'src/app/services/apis/course.service';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './course-edit.component.html',
  styles: [
  ]
})
export class CourseEditComponent {

  form:FormGroup
  loginId?:string

  constructor(
    private builder:FormBuilder,
    route:ActivatedRoute,
    security:SecurityService,
    private courseService: CourseService) {
    this.form = builder.group({
      id: 0,
      name: '',
      category: '',
      description: '',
      image: '',
      hours: 0,
      fees: 0,
      objectives: builder.array([])
    })

    this.loginId = security.loginId

    route.queryParamMap.subscribe(map => {
      let courseId = map.get('id')

      if(courseId) {
        let id = Number.parseInt(courseId)
        courseService.findCourseDetails(id).subscribe(result => {
          const {objectives, ... others} = result
          this.form.patchValue(others)

          this.setObjectives(objectives)
        })
      }
    })
  }

  save() {
    if(this.form.valid) {
      this.courseService.save(this.form.value)
    }
  }

  addObjective() {
    this.objectives.push(this.builder.control(['', Validators.required]))
  }

  removeObjective(index:number) {
    this.objectives.removeAt(index)

    if(this.objectives.length == 0) {
      this.addObjective()
    }
  }

  get objectives() {
    return this.form.get('objectives') as FormArray
  }

  private setObjectives(array:string[]) {
    if(array) {
      for(let item in array) {
        this.objectives.push(this.builder.control([item, Validators.required]))
      }
    }
  }
}
