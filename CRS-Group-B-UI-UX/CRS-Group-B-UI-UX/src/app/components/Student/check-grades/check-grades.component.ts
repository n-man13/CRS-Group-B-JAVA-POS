import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/model/course';
import { Grade } from 'src/app/model/grade';
import { Professor } from 'src/app/model/professor';
import { Student } from 'src/app/model/student';
import { RegisteredCourseService } from 'src/app/services/student/registered-course.service';

@Component({
  selector: 'app-check-grades',
  templateUrl: './check-grades.component.html',
  styleUrls: ['./check-grades.component.scss']
})
export class CheckGradesComponent implements OnInit {

  student: Student = new Student(1, "Luca", "Lucam", "1234", true);
  grades: Grade[] = new Array();
  courses: Course[] = new Array();

  constructor(private registeredCourseService: RegisteredCourseService) { }

  ngOnInit(): void {
    this.getGrades();

  }

  getGrades() {
    console.log("running grades")
    this.registeredCourseService.checkGrades(this.student).subscribe(data => {
      console.log(data);
      this.grades = data;
      this.getProfessors();
    });

  }

  getProfessors() {
    console.log("running professors");
    for (let grade of this.grades){
      if (grade.course.professor == null){
        grade.course.professor = new Professor(0, "No Professor", "", "");
      }
    }
    /* this.grades.forEach(function(value,key){
      console.log(key.name);
    })
    for (let course of this.grades.keys()){
      console.log(course.name);
      this.courses.push(course);
    }  */
  }

}
