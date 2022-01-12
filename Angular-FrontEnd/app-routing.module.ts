import {  NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListUsersComponent } from './list-users/list-users.component';
import { LoginComponent } from './login/login.component';
import { UpdateComponent } from './update/update.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';

const routes: Routes = [
  { path:'',redirectTo:"login",pathMatch:"full"},
  {path: 'users-list', component:ListUsersComponent},
  { path:"users",component:UserRegistrationComponent},
  { path:"login",component:LoginComponent},
  { path:"update-user/:id",component:UpdateComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
