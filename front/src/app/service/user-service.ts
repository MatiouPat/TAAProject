import {Injectable, InjectionToken} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private baseUrl: string;

  constructor(private http: HttpClient)
  {
    this.baseUrl = 'http://localhost:8080/User';
  }

  public findAll(): Observable<User[]>
  {
    return this.http.get<User[]>(this.baseUrl + '/getUsers');
  }

}
