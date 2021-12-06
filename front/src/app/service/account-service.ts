import {Inject, Injectable, InjectionToken} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject, of, throwError } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Professional } from '../model/professional';
import {Account} from "../model/account";
import {StorageService} from "ngx-webstorage-service";


@Injectable()
export class AccountService {

  private baseUrl: string;

  private currentAccountSubject: BehaviorSubject<Account>;
  public currentAccount: Observable<Account>;

  constructor(private http: HttpClient)
  {
    this.baseUrl = 'http://localhost:8080/account';
    // @ts-ignore
    this.currentAccountSubject = new BehaviorSubject<Account>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentAccount = this.currentAccountSubject.asObservable();
  }

  public get currentAccountValue(): Account {
    return this.currentAccountSubject.value;
  }

  public findAll(): Observable<Professional[]>
  {
    return this.http.get<Professional[]>(this.baseUrl + '/getProfessionals');
  }

  public login(account:Account):Observable<any>
  {
    return this.http.post<Account>(this.baseUrl + '/login', account)
      .pipe(map((account) => {
          if (account){
            localStorage.setItem('currentUser', JSON.stringify(account))
            this.currentAccountSubject.next(account);
          }
        })
      )
  }

}
