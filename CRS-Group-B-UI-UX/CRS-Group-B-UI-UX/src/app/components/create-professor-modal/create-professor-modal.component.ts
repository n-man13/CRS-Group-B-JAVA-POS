import { Component, OnInit } from '@angular/core';
import { Professor } from 'src/app/model/professor';

@Component({
  selector: 'app-create-professor-modal',
  templateUrl: './create-professor-modal.component.html',
  styleUrls: ['./create-professor-modal.component.scss']
})
export class CreateProfessorModalComponent implements OnInit {

  professorArray: Array<Professor> = new Array();
  id: number = 1;
  model: Professor = new Professor(0, "", "", "");

  constructor() { }

  ngOnInit(): void {
  }

  createProfessor() {
    this.professorArray.push(new Professor(this.id, this.model.name, this.model.username, this.model.password));
    this.id++;
    console.log("new professor added: " + this.model.name);
  }

}
