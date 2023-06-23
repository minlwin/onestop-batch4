import { Pipe, PipeTransform } from '@angular/core';
import { environment } from 'src/environments/environment';

@Pipe({
  name: 'profileImage'
})
export class ProfileImagePipe implements PipeTransform {

  transform(image?: string): unknown {

    if(image) {
      return `${environment.baseUrl}/images/profile/${image}`
    }

    return '/assets/images/profile.png';
  }

}
