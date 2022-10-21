import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/model/course';
import { Student } from 'src/app/model/student';
import { CourseService } from 'src/app/services/student/course.service';

@Component({
  selector: 'app-view-all-courses',
  templateUrl: './view-all-courses.component.html',
  styleUrls: ['./view-all-courses.component.scss']
})
export class ViewAllCoursesComponent implements OnInit {

  student:Student = new Student(1, "Luca", "Lucam", "1234", true);

  allCourses: Course[] | undefined;

  myCourses: Course[] | undefined;

  constructor(private _httpService: CourseService) { }

  ngOnInit(): void {

    this.getCourses();
    this.getApplyedCourse();

  }

  getCourses() {

    this._httpService.getCourses().subscribe(data => {
      console.log(data);
      this.allCourses = data;
    })

  }

  getApplyedCourse() {

    this._httpService.getCourses().subscribe(data => {
      console.log(data);
      this.myCourses = data;
    })

  }

  applyToCourse(course:Course) {

    this._httpService.getAppliedCourses(this.student).subscribe(data => {
      console.log(data);
      this.allCourses = data;
    })

  }

}
