import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListCourseComponent } from './components/list-course/list-course.component';
import { CreateCourseModalComponent } from './components/Admin/create-course-modal/create-course-modal.component';
import { CreateProfessorModalComponent } from './components/create-professor-modal/create-professor-modal.component';
import { ListProfessorComponent } from './components/list-professor/list-professor.component';
import { ListUnregisteredStudentComponent } from './components/list-unregistered-student/list-unregistered-student.component';
import { MdbAccordionModule } from 'mdb-angular-ui-kit/accordion';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { MdbCheckboxModule } from 'mdb-angular-ui-kit/checkbox';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { MdbDropdownModule } from 'mdb-angular-ui-kit/dropdown';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { MdbPopoverModule } from 'mdb-angular-ui-kit/popover';
import { MdbRadioModule } from 'mdb-angular-ui-kit/radio';
import { MdbRangeModule } from 'mdb-angular-ui-kit/range';
import { MdbRippleModule } from 'mdb-angular-ui-kit/ripple';
import { MdbScrollspyModule } from 'mdb-angular-ui-kit/scrollspy';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';
import { MdbTooltipModule } from 'mdb-angular-ui-kit/tooltip';
import { MdbValidationModule } from 'mdb-angular-ui-kit/validation';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddCourseComponent } from './components/Student/add-course/add-course.component';
import { DropCourseComponent } from './components/Student/drop-course/drop-course.component';
import { ViewAppliedCoursesComponent } from './components/Student/view-applied-courses/view-applied-courses.component';
import { MakePaymentComponent } from './components/Student/make-payment/make-payment.component';
import { CheckGradesComponent } from './components/Student/check-grades/check-grades.component';

@NgModule({
  declarations: [
    AppComponent,
    ListCourseComponent,
    CreateCourseModalComponent,
    CreateProfessorModalComponent,
    ListProfessorComponent,
    ListUnregisteredStudentComponent,
    AddCourseComponent,
    DropCourseComponent,
    ViewAppliedCoursesComponent,
    MakePaymentComponent,
    CheckGradesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MdbAccordionModule,
    MdbCarouselModule,
    MdbCheckboxModule,
    MdbCollapseModule,
    MdbDropdownModule,
    MdbFormsModule,
    MdbModalModule,
    MdbPopoverModule,
    MdbRadioModule,
    MdbRangeModule,
    MdbRippleModule,
    MdbScrollspyModule,
    MdbTabsModule,
    MdbTooltipModule,
    MdbValidationModule,
    NoopAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
