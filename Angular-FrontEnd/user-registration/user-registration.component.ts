import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Register } from '../register';


import { UserRegistrationService } from '../user-registration.service';


@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  register: Register=new Register(0,"","","","","","");
  message:any

  constructor(private service:UserRegistrationService,private router:Router) { }

  ngOnInit(): void {
  }



  

public saveUser()
{
this.service.registerUser(this.register).subscribe((result)=>{
  console.log(result);
  this.gotoUserList();
  alert(this.register.name+" you Registered Sucessfully ! ");
},(error)=>{
  alert("Same Email Cant Allowed");
  this.message="Same Email Cant Allowed";
  console.log("User Not Registered ")
}

);

}

  public gotoUserList(){
    this.router.navigate(['/users-list']);
  }
  
  
  }



