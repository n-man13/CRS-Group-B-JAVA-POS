import { Component, NgModule, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MatTableDataSource } from '@angular/material/table';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit{
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin', "*");
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = new MatTableDataSource<Object>

  constructor(private formBuilder: FormBuilder, private http: HttpClient){}
  ngOnInit(): void {
    this.informationForm = new FormGroup({
      'name': new FormControl(null, [Validators.minLength(2)]), // can pass RegEx
      'dateOfBirth': new FormControl(null),
      'insertTime': new FormControl(null)
    });
  }

  informationForm!: FormGroup;

  // informationForm = this.formBuilder.group({
  //   name: [''],
  //   dateOfBirth:[''],
  //   insertTime:['']
  // });
  title = 'my-form';

  submit(){
    console.log(this.informationForm.value);
    this.http.post("http://localhost:8091/submitInfo", this.informationForm.value, {headers: this.headers}).subscribe(data=>{
      console.log(data);
    })
  }
  search(){
    console.log("searching for items");
  }
}
