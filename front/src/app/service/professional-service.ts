import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Professional } from '../model/professional';

@Injectable({
  providedIn: 'root'
})
export class ProfessionalService {

  private baseUrl: string;

  constructor(private http: HttpClient)
  {
    this.baseUrl = 'http://localhost:8080/Professional';
  }

  public findAll(): Observable<Professional[]>
  {
    return this.http.get<Professional[]>(this.baseUrl + '/getProfessionals');
  }

  public addProfessional(p:Professional)
  {
	console.log("creating professional by p data");
	console.log(p.firstname+" "+p.lastname);
    return this.http.post(this.baseUrl + '/create',p);
  }

}
