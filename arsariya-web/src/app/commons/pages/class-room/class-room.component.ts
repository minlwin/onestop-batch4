import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SecurityService } from 'src/app/services/security/security.service';

@Component({
  templateUrl: './class-room.component.html',
  styles: [
  ]
})
export class ClassRoomComponent {

  course:any

  constructor(route:ActivatedRoute, private security:SecurityService) {
    route.queryParamMap.subscribe(map => {
      var id = map.get('courseId')

      if(id) {

      }
    })
  }

  get isTeacher() {
    return this.security.role == 'Teacher'
  }
}
