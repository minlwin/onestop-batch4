import { AfterViewInit, Component, Input } from '@angular/core';

declare const bootstrap:any

@Component({
  selector: 'app-modal-dialog',
  templateUrl: './modal-dialog.component.html',
  styles: [
  ]
})
export class ModalDialogComponent implements AfterViewInit{

  @Input()
  modelId?:string

  private dialog:any

  ngAfterViewInit(): void {
    this.dialog = new bootstrap.Modal(`#${this.modelId}`)
  }

  show() {
    this.dialog?.show()
  }

  hide() {
    this.dialog?.hide()
  }

}
