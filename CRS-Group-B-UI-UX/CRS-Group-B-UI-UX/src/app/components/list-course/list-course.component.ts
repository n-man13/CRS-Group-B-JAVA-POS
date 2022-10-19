import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/model/course';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { CourseService } from 'src/app/services/course.service';

@Component({
  selector: 'app-list-course',
  templateUrl: './list-course.component.html',
  styleUrls: ['./list-course.component.scss']
})
export class ListCourseComponent implements OnInit {

  courseArray:Array<Course> = new Array();

  id:number = 1;

  isFound:boolean = false;

  model:Course = new Course(0, '', '', '',0, 0);

  getData:Course[] | undefined;

  constructor(private _httpService:CourseService) {}

  ngOnInit(): void {
  }

  createUpdateCourse() {

    this.courseArray.forEach(course => {
      if (this.model.courseID == course.courseID) {
        course.courseID = this.model.courseID;
        course.name = this.model.name;
        course.description = this.model.description;
        course.department = this.model.department;
        course.prereqID = this.model.prereqID;
        this.isFound = true;
      }
      
    });
    if (!this.isFound) {
      this.courseArray.push(new Course(this.id, this.model.name, this.model.description, this.model.department, this.model.professorID, this.model.prereqID));
      this.id++;
    }
    this.isFound = false;

  }

  getCourses() {
    
    this._httpService.getCourses().subscribe(data => {
      console.log(data);
      this.getData = data;
    })
  }

  updateCourse(course:Course) {
     this.model.courseID = course.courseID;
     this.model.name = course.name;
     this.model.description = course.description;
     this.model.department = course.department;
    this.model.prereqID = course.prereqID;
  }

  deleteCourse(course:Course) {
    let index = this.courseArray.indexOf(course);
    if (index !== -1) {
      this.courseArray.splice(index, 1);
    }
  }

}
