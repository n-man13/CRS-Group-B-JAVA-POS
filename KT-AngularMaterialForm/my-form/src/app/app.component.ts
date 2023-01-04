import { Component, NgModule } from '@angular/core';
import { FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  constructor(private formBuilder: FormBuilder){}
  profileForm = this.formBuilder.group({
    name: [''],
    dateOfBirth:[''],
    insertTime:['']
  })
  title = 'my-form';
}
