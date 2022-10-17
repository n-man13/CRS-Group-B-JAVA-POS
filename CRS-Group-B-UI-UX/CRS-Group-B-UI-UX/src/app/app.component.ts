import { Component } from '@angular/core';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { CreateCourseModalComponent } from './components/create-course-modal/create-course-modal.component';
import { Course } from './model/course';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  modalRef: MdbModalRef<CreateCourseModalComponent> | null = null;
  course:Course = new Course(0, "", "", "", 0, 0);
  constructor(private modalService: MdbModalService) {}
  
  
  title = 'CRS-Group-B-UI-UX';

  openModal() {
    this.modalRef = this.modalService.open(CreateCourseModalComponent);
  }
}
