import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/model/course';
import { Professor } from 'src/app/model/professor';
import { CourseService } from 'src/app/services/professor/course.service';

@Component({
  selector: 'app-view-courses',
  templateUrl: './view-courses.component.html',
  styleUrls: ['./view-courses.component.scss']
})
export class ViewCoursesComponent implements OnInit {

  professor: Professor = new Professor(2, "Amit", "amit", "1234")

  model: Course = new Course(0, '', '', '', 0, new Professor(0, "", "", ""));

  getData: Course[] | undefined;

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {

    this.getCourses();

  }

  getCourses() {

    this.courseService.getCourses().subscribe(data => {
      console.log(data);
      this.getData = data;
    })

  }

  applyToCourse(course:Course) {
    this.courseService.applyToCourse(course, this.professor).subscribe(data => {
      console.log(data);
    })
  }

}
