import { Pipe, PipeTransform } from '@angular/core';
import { environment } from 'src/environments/environment';

@Pipe({
  name: 'courseImage'
})
export class CourseImagePipe implements PipeTransform {

  transform(image?: string): unknown {
    if(image) {
      return `${environment.baseUrl}/images/course/${image}`
    }

    return '/assets/images/course-cover.png';
  }

}
