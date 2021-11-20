import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { ProfessionalListComponent } from './professional-list/professional-list.component';
import { InscriptionComponent } from './inscription/inscription.component';

const routes: Routes = [
  { path: 'User/getUsers', component: UserListComponent},
  { path: 'Professional/getProfessionals', component: ProfessionalListComponent},
  { path: 'Professional/createProfessional', component: InscriptionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
