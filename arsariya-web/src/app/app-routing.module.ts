import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'anonymous', loadChildren: () => import('./business/anonymous/anonymous.module').then(m => m.AnonymousModule)},
  {path: 'admin', loadChildren: () => import('./business/admin/admin.module').then(m => m.AdminModule)},
  {path: 'student', loadChildren: () => import('./business/student/student.module').then(m => m.StudentModule)},
  {path: 'teacher', loadChildren: () => import('./business/teacher/teacher.module').then(m => m.TeacherModule)},
  {path: '', redirectTo: '/anonymous', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
