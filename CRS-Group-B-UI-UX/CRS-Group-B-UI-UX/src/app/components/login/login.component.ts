import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  model: any = {};

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit(): void {
  }

  // Logic for Login user 

  loginUser() {

    console.log(this.model.username, this.model.password);
    var user = this.model.username;
    var password = this.model.password;
    console.log(user);
    console.log(password)
    //let user=this.model.username;
    //let password=this.model.password;
    // Service Call ang Auth Data form  // U take form  Service
    if (user == 'admin' && password == 'admin') {
      console.log(this.model.user);
      console.log(this.model.password);
      this.router.navigate(['admindashboard', {username: this.model.username}]); //send data via routing

    }

  }

}
