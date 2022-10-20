import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Course } from '../model/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  url: string = "http://localhost:7001/courses/";

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', "*");

  constructor(private httpClient: HttpClient) { }

  model:Course = new Course(0, 0,"","","",0,0);


  getCourses(): Observable<any> {

    return this.httpClient.get(this.url + "list", { headers: this.headers });

  }

  createCourse(customer: Course): Observable<any> {

    const body = JSON.stringify(customer);
    return this.httpClient.post(this.url + "create", body, { headers: this.headers });

  }

  updateCourse(course: Course): Observable<any> {

    const body = JSON.stringify(course);
    return this.httpClient.put(this.url + "update/" + course.id, body, { headers: this.headers });

  }

  deleteCourse(course: Course): Observable<any> {

    const body = JSON.stringify(course);
    let httpOptions = {};
    return this.httpClient.delete(this.url + "delete/" + course.id, httpOptions);

  }

  saveInfo(course: Course) {
    this.model = course;
  }

}


