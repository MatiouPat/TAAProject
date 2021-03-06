import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject, of, throwError } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Professional } from '../model/professional';

@Injectable()
export class ProfessionalService {

  private baseUrl: string;

  constructor(private http: HttpClient)
  {
    this.baseUrl = 'http://localhost:8080/professional';
  }

  public findAll(): Observable<Professional[]>
  {
    return this.http.get<Professional[]>(this.baseUrl + '/getProfessionals');
  }

  public register(p:Professional):Observable<any>
  {
    return this.http.post<Professional>(this.baseUrl + '/create', p)
      .pipe(
        map(res => {
          return res;
        }),
        catchError(error => {
          //return of(error);
          return throwError(error);
        })
      );
  }

}
