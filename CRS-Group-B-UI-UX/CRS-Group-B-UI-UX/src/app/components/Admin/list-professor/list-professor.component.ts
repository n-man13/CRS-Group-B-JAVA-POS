import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Professor } from 'src/app/model/professor';
import { ProfessorService } from 'src/app/services/admin/professor.service';

@Component({
  selector: 'app-list-professor',
  templateUrl: './list-professor.component.html',
  styleUrls: ['./list-professor.component.scss']
})
export class ListProfessorComponent implements OnInit {

  
  model: Professor = new Professor(0, "", "", "");
  getData: Professor[] | undefined;

  constructor(private httpService: ProfessorService, public router: Router) { }

  ngOnInit(): void {
    this.getProfessors()
  }


  getProfessors() {
    this.httpService.getProfessors().subscribe(data => {
      console.log(data);
      this.getData = data;
    })
  }
}