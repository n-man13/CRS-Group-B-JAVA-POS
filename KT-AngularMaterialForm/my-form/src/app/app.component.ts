import { Component, NgModule } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', "*");

  constructor(private formBuilder: FormBuilder, private http: HttpClient){}
  informationForm = this.formBuilder.group({
    name: [''],
    dateOfBirth:[''],
    insertTime:['']
  });
  title = 'my-form';

  submit(){
    console.log(this.informationForm.value);
    return this.http.post("http://localhost:8091/submitInfo", this.informationForm.value, {headers: this.headers});
  }
}
