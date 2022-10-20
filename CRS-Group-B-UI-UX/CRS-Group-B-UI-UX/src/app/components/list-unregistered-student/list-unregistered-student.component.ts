import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from 'src/app/model/student';
import { StudentService } from 'src/app/services/student.service';


@Component({
  selector: 'app-list-unregistered-student',
  templateUrl: './list-unregistered-student.component.html',
  styleUrls: ['./list-unregistered-student.component.scss']
})
export class ListUnregisteredStudentComponent implements OnInit {

  // studentArray:Student[] = new Array();
  model: Student = new Student(0, "", "", "", false);
  getData: Student[] | undefined;

  constructor(private httpService: StudentService, public router: Router) { 
    // let s1:Student = new Student(1, "Luca", "Lucam", "1234", false);
    // let s2:Student = new Student(2, "Seb", "Seba", "1234", false);
    // let s3:Student = new Student(3, "Nikhil", "Nik", "1234", false);
    // this.studentArray.push(s1,s2,s3);
    
  }

  ngOnInit(): void {
    this.getStudents();
  }

  // studentRegistration(student:Student) {
  //   console.log(JSON.stringify(student));
  //   let index = this.studentArray.indexOf(student);
  //   console.log(index);
  //   console.log(JSON.stringify(this.studentArray[index]));
  //   if (index != -1) {
  //       this.studentArray[index].isRegistered = true;
  //   }
  // }

  getStudents() {
    this.httpService.getStudents().subscribe(data => {
      console.log(data);
      this.getData = data;
    })
  }

  confirmRegistration(student:Student) {
    student.isRegistered = true;
    this.httpService.confirmRegistration(student)
      .subscribe(data => {
        console.log(data);
        this.getStudents();
        this.router.navigate(['listunregisteredstudent']);
        
      })
  }

  rejectRegistration(student: Student) {

    this.httpService.rejectRegistration(student)
      .subscribe(data => {
        this.getStudents();
        console.log(data)
      })


  }
  
}
