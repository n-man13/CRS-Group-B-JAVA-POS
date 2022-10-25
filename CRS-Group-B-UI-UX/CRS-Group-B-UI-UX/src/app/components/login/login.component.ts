import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  model: User = new User(0, "", "", 0);

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit(): void {
  }

  // Logic for Login user 

  loginUser() {




    switch (this.model.role) {
      case 1:
        this.userService.checkLogin(this.model.username, this.model.password, this.model.role).subscribe(data => {
          this.router.navigate(['admindashboard', { admin: data }]);
        })
        break;
      case 2:
        this.userService.checkLogin(this.model.username, this.model.password, this.model.role).subscribe(data => {
          this.router.navigate(['professordashboard', { professor: data }]);
        })
        break;
      case 3:
        this.userService.checkLogin(this.model.username, this.model.password, this.model.role).subscribe(data => {
          this.router.navigate(['studentdashboard', { student: data }]);
        })
        break;
    }




  }

}


