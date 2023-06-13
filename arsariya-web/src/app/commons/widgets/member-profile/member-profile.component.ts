import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-member-profile',
  templateUrl: './member-profile.component.html',
  styles: [
  ]
})
export class MemberProfileComponent {

  @Input()
  profile:any

  @Input()
  canEdit?:boolean

  @Output()
  onEdit = new EventEmitter

  edit() {
    if(this.canEdit) {
      this.onEdit.emit(this.profile)
    }
  }
}
