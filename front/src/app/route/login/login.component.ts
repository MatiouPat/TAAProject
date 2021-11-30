import { Component, OnInit } from '@angular/core';
import {Professional} from "../../model/professional";
import {Account} from "../../model/account";
import {ActivatedRoute, Router} from "@angular/router";
import {ProfessionalService} from "../../service/professional-service";
import {AccountService} from "../../service/account-service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  professional:Professional;
  account:Account;

  constructor(private route: ActivatedRoute, private router: Router, 
	private professionalService: ProfessionalService, private accountService: AccountService)
  {
    this.professional = new Professional();
	this.account = new Account();
  }



  ngOnInit(): void {
  }

  login()
  {

  }

  onSubmit()
  {
    function gotoProfessionalList() {
		
    }
	
	console.log(this.professional);
    this.professionalService.addProfessional(this.professional).subscribe(result => gotoProfessionalList());

  }


  gotoProfessionalList()
  {
    this.router.navigate(['Professional/getProfessionals'])
  }

}
