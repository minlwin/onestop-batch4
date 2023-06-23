import { FormGroup } from "@angular/forms";

export abstract class PagerListComponent {

  sizes:number[] = [10, 25, 50]

  abstract get form():FormGroup
  abstract search():void

  changePage(page:number) {
    this.form.patchValue({current: page})
    this.search()
  }

  changePageSize(size:number) {
    this.form.patchValue({size: size, current: 0})
    this.search()
  }
}
