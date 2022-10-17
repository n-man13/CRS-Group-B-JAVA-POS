import { Component, OnInit } from '@angular/core';
import { Professor } from 'src/app/model/professor';

@Component({
  selector: 'app-list-professor',
  templateUrl: './list-professor.component.html',
  styleUrls: ['./list-professor.component.scss']
})
export class ListProfessorComponent implements OnInit {

  professorArray: Array<Professor> = new Array();
  id: number = 1;
  model: Professor = new Professor(0, "", "", "");
  
  constructor() { }

  ngOnInit(): void {
  }

}
