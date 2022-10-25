import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/model/course';
import { Grade } from 'src/app/model/grade';
import { Professor } from 'src/app/model/professor';
import { CourseService } from 'src/app/services/professor/course.service';

@Component({
  selector: 'app-view-students',
  templateUrl: './view-students.component.html',
  styleUrls: ['./view-students.component.scss']
})
export class ViewStudentsComponent implements OnInit {

  student: Professor = new Professor(2, "Amit", "Amit", "1234");
  grades: Grade[] = new Array();
  courses: Course[] = new Array();
  isEditable:boolean = false;

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    

  }

  getStudents(courseID:number){
    this.courseService.getMyStudents(courseID).subscribe(data => {
      console.log(data);
    })
  }

  editToggle() {
    this.isEditable = !this.isEditable;
  }

  

}
