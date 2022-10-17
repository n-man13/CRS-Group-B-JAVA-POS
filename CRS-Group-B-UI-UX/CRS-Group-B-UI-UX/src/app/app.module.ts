import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfessorComponent } from './components/professor/professor.component';
import { StudentComponent } from './components/student/student.component';
import { CourseComponent } from './components/course/course.component';
import { MdbModalModule  } from 'mdb-angular-ui-kit/modal';


@NgModule({
  declarations: [
    AppComponent,
    ProfessorComponent,
    StudentComponent,
    CourseComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MdbModalModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
