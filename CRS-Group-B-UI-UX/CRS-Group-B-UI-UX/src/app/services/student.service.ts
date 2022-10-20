import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../model/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {


  url: string = "http://localhost:7003/students/";

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', "*")

  constructor(private httpClient: HttpClient) { }

  model:Student = new Student(0,"", "", "", false);

  getStudents(): Observable<any>{
    return this.httpClient.get(this.url, { headers: this.headers });
  }

  confirmRegistration(student: Student): Observable<any> {

    const body = JSON.stringify(student);
    return this.httpClient.put(this.url + "register/" + student.id, body, { headers: this.headers });

  }

  rejectRegistration(student: Student): Observable<any> {

    const body = JSON.stringify(student);
    let httpOptions = {};
    return this.httpClient.delete(this.url + "register/" + student.id, httpOptions);

  }


}
