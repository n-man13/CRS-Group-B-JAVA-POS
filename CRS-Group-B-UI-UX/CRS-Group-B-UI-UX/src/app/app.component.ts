import { Component } from '@angular/core';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { CourseComponent } from './components/course/course.component';
import { CreateCourseModalComponent } from './components/create-course-modal/create-course-modal/create-course-modal.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  modalRef: MdbModalRef<CreateCourseModalComponent> | null = null;

  constructor(private modalService: MdbModalService) {}

  
  title = 'CRS-Group-B-UI-UX';

  openModal() {
    this.modalRef = this.modalService.open(CreateCourseModalComponent);
  }
}
