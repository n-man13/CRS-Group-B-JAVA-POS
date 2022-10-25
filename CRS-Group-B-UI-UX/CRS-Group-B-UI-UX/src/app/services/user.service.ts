import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url: string = "http://localhost:8094/";
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', "*");

  constructor(private http: HttpClient) { }

  checkLogin(username: string, password: string, role: number): Observable<any> {
    let user: User = new User(0,username, password, role);
    return this.http.post(this.url + "login", user, { headers: this.headers });
  }
}
