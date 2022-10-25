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

  professor: Professor = new Professor(2, "Amit", "Amit", "1234");
  grades: Grade[] = new Array();
  courses: Course[] = new Array();
  isEditable:boolean = false;
  editableId:number[] = new Array();
  model:number = -1;

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    

  }

  getStudents(courseID:number){
    this.courseService.getMyStudents(courseID, this.professor).subscribe(data => {
      console.log(data);
    })
  }

  editToggle(id:number) {
    this.editableId.push(id);
  }

  checkId(id:number) {
    this.editableId.includes(id);
  }

  saveGrade(grade:Grade) {
    this.courseService.recordGrade(grade.course, grade.student, this.model);
    let index:number = this.editableId.indexOf(grade.student.studentID);
    this.editableId.splice(index, 1);
  }

  getMyCourses(){
    this.courseService.getMyCourses(this.professor).subscribe(data =>{
      this.courses = data;
    })
  }



  

}
