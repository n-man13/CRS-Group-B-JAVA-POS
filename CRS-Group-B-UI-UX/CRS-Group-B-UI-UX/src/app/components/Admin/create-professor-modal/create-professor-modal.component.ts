import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Professor } from 'src/app/model/professor';
import { ProfessorService } from 'src/app/services/admin/professor.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-create-professor-modal',
  templateUrl: './create-professor-modal.component.html',
  styleUrls: ['./create-professor-modal.component.scss']
})
export class CreateProfessorModalComponent implements OnInit {


  model: Professor = new Professor(0, "", "", "");

  constructor(private httpService: ProfessorService, private userService: UserService, public router: Router) { }

  ngOnInit(): void {
    if (JSON.parse(this.userService.getData() as string).role != 1) {
      this.userService.deleteData();
      this.router.navigate(['']);
    }
  }

  createProfessor() {
    this.httpService.addProfessor(this.model)
      .subscribe(data => {
        console.log(data);
        this.router.navigate(['admindashboard/listprofessor']);
      })
    
  }

}
