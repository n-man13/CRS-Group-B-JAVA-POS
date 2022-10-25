import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from 'src/app/model/course';
import { Professor } from 'src/app/model/professor';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  url: string = "http://localhost:8092/";
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', "*");

  constructor(private http: HttpClient) { }

  getCourses(): Observable<any> {
    return this.http.get(this.url + "viewAllCourses", { headers: this.headers });
  }

  applyToCourse(course: Course, professor: Professor){
    return this.http.put(this.url + "applyToCourseProfessor/" + course.courseID + "/" + professor.professorID, { headers: this.headers });
  }
}
