import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateCourseModalComponent } from './components/Admin/create-course-modal/create-course-modal.component';
import { CreateProfessorModalComponent } from './components/Admin/create-professor-modal/create-professor-modal.component';
import { ListCourseComponent } from './components/Admin/list-course/list-course.component';
import { ListProfessorComponent } from './components/Admin/list-professor/list-professor.component';
import { ListUnregisteredStudentComponent } from './components/Admin/list-unregistered-student/list-unregistered-student.component';
import { ViewCoursesComponent } from './components/Professor/view-courses/view-courses.component';
import { ViewStudentsComponent } from './components/Professor/view-students/view-students.component';
import { CheckGradesComponent } from './components/Student/check-grades/check-grades.component';
import { ViewAllCoursesComponent } from './components/Student/view-all-courses/view-all-courses.component';
import { ViewAppliedCoursesComponent } from './components/Student/view-applied-courses/view-applied-courses.component';

const routes: Routes = [
  {path:'', redirectTo: 'home', pathMatch:'full'},
/*   {path:'listcourse', component:ListCourseComponent},
  {path:'courseform', component:CreateCourseModalComponent},
  {path:'listprofessor', component:ListProfessorComponent},
  {path:'professorform', component:CreateProfessorModalComponent},
  {path:'listunregisteredstudent', component:ListUnregisteredStudentComponent}, */
  {path:'viewcourses', component:ViewCoursesComponent},
  {path:'viewstudents', component:ViewStudentsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
