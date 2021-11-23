import { Component, OnInit } from '@angular/core';
import { Professional } from '../model/professional';
import { ProfessionalService } from '../service/professional-service';

@Component({
  selector: 'app-professional-list',
  templateUrl: './professional-list.component.html',
  styleUrls: ['./professional-list.component.css']
})
export class ProfessionalListComponent implements OnInit {

  professionals:Professional[];

  constructor(private professionalService: ProfessionalService) { }

  ngOnInit(): void {
    this.professionalService.findAll().subscribe(data => {
      this.professionals = data;
    })
  }
}