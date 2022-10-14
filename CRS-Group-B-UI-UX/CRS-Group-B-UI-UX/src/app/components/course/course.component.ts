import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/model/course';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  createCourse() {

  }

  updateCourse(course:Course) {

  }

  deleteCourse(course:Course) {
    
  }

}
