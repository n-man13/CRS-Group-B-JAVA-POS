import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CourseService {

  url: string = "http://localhost:8093/";
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', "*");

  constructor(private http: HttpClient) { }

  getCourses(): Observable<any> {
    return this.http.get(this.url + "viewAllCourses", { headers: this.headers });
  }

}
