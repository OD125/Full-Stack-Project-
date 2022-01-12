import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Register } from '../register';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  id:any;
  register:any;
  message:any;

  constructor(private service:UserRegistrationService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {

    this.id=this.route.snapshot.params['id'];
    this.service.getUserById(this.id).subscribe((data)=>{
      this.register=data;
    });
  }


  public updateUser()
{
this.service.updateUser(this.id,this.register).subscribe((result)=>{
  console.log(result);
  this.gotoUserList();
  alert(" User Updated Sucessfully ! ");


},
);

}

  public gotoUserList(){
    this.router.navigate(['/users-list']);
  }
  



}
