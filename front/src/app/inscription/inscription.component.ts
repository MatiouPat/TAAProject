import { Component, OnInit } from '@angular/core';
import { Professional } from '../model/professional';
import { ProfessionalService } from '../service/professional-service';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";



@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

	RegisterForm:FormGroup;
	
	
  constructor(public pS:ProfessionalService,public fb:FormBuilder) { 
	this.RegisterForm=this.fb.group({
      "firstname" : [''],
      "lastname" : [''],
	  "password" : [''],
      "job" : ['']
	})
	}

  ngOnInit(): void {
	this.RegisterForm=this.fb.group({
      "firstname" : ['guillaume'],
      "lastname" : ['subra'],
	  "password" : ['azerty'],
      "job" : ['etudiant']
	})
	
  }

  create(): void {
    let professional :Professional = {
      firstname : this.RegisterForm.get("firstname")?.value,
      lastname : this.RegisterForm.get("lastname")?.value,
	  password : this.RegisterForm.get("password")?.value,
      job : this.RegisterForm.get("job")?.value
    	}

	console.log(professional.firstname+" "+professional.lastname);

	this.pS.addProfessional(professional);

	}

}
