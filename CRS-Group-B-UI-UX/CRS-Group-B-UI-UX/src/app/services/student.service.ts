import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../model/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {


  url: string = "http://localhost:7001/courses/";

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', "*")

  constructor(private httpClient: HttpClient) { }

  model:Student = new Student(0,"", "", "", false);
}
