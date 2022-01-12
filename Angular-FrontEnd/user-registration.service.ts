import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Register } from './register';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {
  

  private baseURL = "http://localhost:8080/users";

  private baseURL1 = "http://localhost:8080/user";



  constructor(public http:HttpClient) { }


  public registerUser(register:Register)
  {
    return this.http.post(this.baseURL, register);
  }
  

  public getUserList()
  {
    return this.http.get(this.baseURL);
  }

  public deleteUser(id: number){
    return this.http.delete(this.baseURL+`/${id}`);
  }

public getUserById(id:number)
{
  return this.http.get(this.baseURL+`/${id}`);
}

public getUserByEmail(email:any)
{
  return this.http.get(this.baseURL1+`/${email}`);
}

public updateUser(id:number,register:Register)
{
  return this.http.put(this.baseURL+`/${id}`,register);
}
}
