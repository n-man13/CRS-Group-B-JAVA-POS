import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/model/course';
import { RegisteredCourse } from 'src/app/model/registered-course';
import { Student } from 'src/app/model/student';
import { CourseService } from 'src/app/services/student/course.service';
import { RegisteredCourseService } from 'src/app/services/student/registered-course.service';

@Component({
  selector: 'app-view-applied-courses',
  templateUrl: './view-applied-courses.component.html',
  styleUrls: ['./view-applied-courses.component.scss']
})
export class ViewAppliedCoursesComponent implements OnInit {

  student:Student = new Student(1, "Luca", "Lucam", "1234", true);

  myCourses: RegisteredCourse [] = [];

  constructor(private courseService: CourseService, private registeredCourseService: RegisteredCourseService) { }

  ngOnInit(): void {

    
    this.getAppliedCourse();    

  }

  getAppliedCourse() {

    this.courseService.getAppliedCourses(this.student).subscribe(data => {
      console.log("applied course Data "+data);
      this.myCourses = data;
      
    })
    console.log("my courses array" + this.myCourses);

  }


payCourse(myCourse : RegisteredCourse) {

  this.registeredCourseService.makePayment(this.student, myCourse.course)
      .subscribe(data => {
        this.getAppliedCourse();
        console.log(data)
      })

}

dropCourse(myCourse : RegisteredCourse) {

  this.registeredCourseService.dropCourse(this.student, myCourse.course)
      .subscribe(data => {
        this.getAppliedCourse();
        console.log(data)
      })
  
}

}
