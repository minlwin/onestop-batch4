import { Directive, ElementRef, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[hoverable]'
})
export class HoverableDirective {

  constructor(private ref:ElementRef) { }

  @Input()
  hoverable:string = ''

  @HostListener('mouseenter')
  onMouseEnter() {
    this.ref.nativeElement.classList.add(this.hoverable)
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.ref.nativeElement.classList.remove(this.hoverable)
  }
}
