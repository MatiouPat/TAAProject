import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./route/login/login.component";
import {HomeComponent} from "./route/home/home.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'home', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
