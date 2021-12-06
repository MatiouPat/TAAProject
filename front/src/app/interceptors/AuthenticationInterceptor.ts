import { Injectable } from "@angular/core";
import { map, catchError } from "rxjs/operators";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpResponse,
  HttpErrorResponse
} from "@angular/common/http";
import { Observable, throwError, of } from "rxjs";
import {AccountService} from "../service/account-service";
import {Router} from "@angular/router";

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

  constructor(private accountService:AccountService, private router:Router) {
  }

  intercept(request:HttpRequest<any>, next:HttpHandler):Observable<HttpEvent<any>> {
    if (this.accountService.currentAccount){
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${this.accountService.currentAccountValue.password}`
        }
      })
    }
    return next.handle(request)
      .pipe(
        map((event:HttpEvent<any>) => {
          if (event instanceof HttpResponse) {
            console.log("Http Response event: ", event);
          }
          return event;
        }),
        catchError(error => {
          console.log("Error response status: ", error.status);
          if (error.status === 401) {
            this.router.navigateByUrl("/login");
          }
          //return of([]);
          return throwError(error);
        }));

  }
}
