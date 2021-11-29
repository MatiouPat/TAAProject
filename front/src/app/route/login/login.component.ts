import { Component, OnInit } from '@angular/core';
import {Professional} from "../../model/professional";
import {ActivatedRoute, Router} from "@angular/router";
import {ProfessionalService} from "../../service/professional-service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  account = {username: '', password: ''}
  professional:Professional;

  constructor(private route: ActivatedRoute, private router: Router, private profesionalService: ProfessionalService)
  {
    this.professional = new Professional();
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

    this.profesionalService.addProfessional(this.professional).subscribe(result => gotoProfessionalList());
  }

  gotoProfessionalList()
  {
    this.router.navigate(['Professional/getProfessionals'])
  }

}
