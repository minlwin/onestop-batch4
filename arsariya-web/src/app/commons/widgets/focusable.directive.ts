import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[focusable]'
})
export class FocusableDirective {

  constructor(private ref:ElementRef) { }

  @HostListener('mouseenter')
  onMouseEnter() {
    this.ref.nativeElement.classList.add('shadow')
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.ref.nativeElement.classList.remove('shadow')
  }

}
