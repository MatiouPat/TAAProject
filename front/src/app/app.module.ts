import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserService } from './service/user-service';
import { ProfessionalService } from './service/professional-service';
import { UserListComponent } from './user-list/user-list.component';
import { ProfessionalListComponent } from './professional-list/professional-list.component';
import { InscriptionComponent } from './inscription/inscription.component';
import {HomeComponent} from "./route/home/home.component";
import {LoginComponent} from "./route/login/login.component";

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    ProfessionalListComponent,
    InscriptionComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
	  ReactiveFormsModule,
	  FormsModule,
  ],
  providers: [UserService,ProfessionalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
