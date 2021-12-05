import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AccountService} from "../../service/account-service";
import {Account} from "../../model/account";
import {Professional} from "../../model/professional";
import {ProfessionalService} from "../../service/professional-service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  account:Account;
  professional:Professional;


  constructor(private route: ActivatedRoute, private router: Router, private accountService: AccountService, private professionalService: ProfessionalService)
  {
    this.account = new Account();
    this.professional = new Professional()
  }

  ngOnInit(): void {
  }

  login():void
  {
    this.accountService.login(this.account).subscribe(
      result => {
        if (result.responseCode != "OK") {

        } else {
          this.router.navigateByUrl('/home');
        }
      })
  }

  register():void
  {
    this.professionalService.register(this.professional).subscribe(
      result => {
        console.log(result);
      })
  }

}
