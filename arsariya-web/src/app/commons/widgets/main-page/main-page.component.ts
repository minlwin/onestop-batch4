import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styles: [
  ]
})
export class MainPageComponent {

  @Input()
  icon?:string

  @Input()
  title:string = ''
}
