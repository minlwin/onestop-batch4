import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-course-item',
  templateUrl: './course-item.component.html',
  styles: [
  ]
})
export class CourseItemComponent {
  @Input()
  course:any

  @Output()
  showDetailsListener = new EventEmitter

  showDetails() {
    this.showDetailsListener.emit(this.course.id)
  }
}
