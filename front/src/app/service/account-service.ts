import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject, of, throwError } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Professional } from '../model/professional';
import {Account} from "../model/account";

@Injectable()
export class AccountService {

  private baseUrl: string;

  constructor(private http: HttpClient)
  {
    this.baseUrl = 'http://localhost:8080/account';
  }

  public findAll(): Observable<Professional[]>
  {
    return this.http.get<Professional[]>(this.baseUrl + '/getProfessionals');
  }

  public login(a:Account):Observable<any>
  {
    console.log(a);
    return this.http.post<Professional>(this.baseUrl + '/login', a)
  }

}
