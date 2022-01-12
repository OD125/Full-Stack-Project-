import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {

  user: any;
  email: any;

  constructor(private service: UserRegistrationService,
    private router: Router) { }

  ngOnInit(): void {
    this.getUsers();

  }

  public getUsers() {
    this.service.getUserList().subscribe(data => {
      this.user = data;
    },
    error=>{
      alert("Users Not Present ");
    });


  }


  public SearchUserByEmail() {
    this.service.getUserByEmail(this.email).subscribe(data => {
      this.user = data;
    },
    error=>alert("Provided Email User Not Present ")
    );


  }

  public deleteUser(id: number) {
    this.service.deleteUser(id).subscribe(data => {
      console.log(data);
      alert("User Deleted Sucessfully")
      this.getUsers();
    });
  }

  public UpdateUser(id: number) {

    this.router.navigate(['update-user', id]);
  }

}
