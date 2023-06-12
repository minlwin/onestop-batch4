import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-search-table',
  templateUrl: './search-table.component.html',
  styles: [
  ]
})
export class SearchTableComponent {

  @Input()
  empty = false

  @Input()
  dataType = ''

}
