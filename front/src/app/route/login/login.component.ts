import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AccountService} from "../../service/account-service";
import {Account} from "../../model/account";
import {Professional} from "../../model/professional";
import {ProfessionalService} from "../../service/professional-service";
import {first} from "rxjs";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  account:Account;
  professional:Professional;
  returnUrl: string | undefined;

  constructor(private route: ActivatedRoute, private router: Router, private accountService: AccountService, private professionalService: ProfessionalService)
  {
    this.account = new Account();
    this.professional = new Professional()
  }

  ngOnInit(): void {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  login():void
  {
    this.accountService.login(this.account)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate([this.returnUrl]);
        });
  }

  register():void
  {
    this.professionalService.register(this.professional).subscribe(
      result => {
        console.log(localStorage.getItem('currentUser'));
      })
  }

}
