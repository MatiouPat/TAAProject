import { Component, OnInit } from '@angular/core';
import { Professional } from '../model/professional';
import { ProfessionalService } from '../service/professional-service';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";



@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent {

	professional:Professional;


  constructor(private route: ActivatedRoute, private router: Router, private profesionalService: ProfessionalService)
  {
    this.professional = new Professional();
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
