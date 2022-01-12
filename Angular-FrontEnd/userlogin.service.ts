import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class UserloginService {


  private baseURL = "http://localhost:8080/login";


  constructor(public http:HttpClient) { }

  public checklogin(login: Login){
    return this.http.post(this.baseURL, login);
  }

}
