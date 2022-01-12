import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../login';
import { UserloginService } from '../userlogin.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: Login=new Login("","");
  UserDetails:any
  message:any


  constructor(private router: Router,private service:UserloginService) { }

  ngOnInit() {
  }

  public checklogin(){
    this.service.checklogin(this.login).subscribe( data =>{
      console.log(data);
      this.UserDetails = data;
      this.gotoregister();
      alert("Log in Sucessfully ! ");
    },
    error=>{
      alert("User Credentials are Bad")
      this.message="User Credentials are Bad";
      console.log("Cant login");
    }
   );
    
    }

  public gotoregister(){
    this.router.navigate(['/users-list']);
  }
  
}