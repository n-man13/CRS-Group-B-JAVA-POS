import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCourseModalComponent } from './components/create-course-modal/create-course-modal.component';
import { CreateProfessorModalComponent } from './components/create-professor-modal/create-professor-modal.component';
import { ListCourseComponent } from './components/list-course/list-course.component';
import { ListProfessorComponent } from './components/list-professor/list-professor.component';
import { ListUnregisteredStudentComponent } from './components/list-unregistered-student/list-unregistered-student.component';

const routes: Routes = [
  {path:'', redirectTo: 'home', pathMatch:'full'},
  {path:'listcourse', component:ListCourseComponent},
  {path:'courseform', component:CreateCourseModalComponent},
  {path:'listprofessor', component:ListProfessorComponent},
  {path:'professorform', component:CreateProfessorModalComponent},
  {path:'listunregisteredstudent', component:ListUnregisteredStudentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
