import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginAdmComponent } from './login-adm.component';

const routes: Routes = [{path:'', component: LoginAdmComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginAdmRoutingModule { }
