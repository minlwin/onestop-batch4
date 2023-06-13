import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student.component';
import { PublicHomeComponent } from 'src/app/commons/pages/public-home/public-home.component';

const routes: Routes = [
  {path: '', component: StudentComponent, children: [
    {path: 'public', component: PublicHomeComponent},

  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
