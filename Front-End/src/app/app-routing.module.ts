import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './interface/login/login.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'editar',
    loadChildren: ()=> import('./interface/editar/editar.module').then(
    (m)=> m.EditarModule
  )},
  {path: 'login-adm',
  loadChildren: ()=> import('./interface/login-adm/login-adm.module').then(
  (m)=> m.LoginAdmModule)},
  {path: 'adm/administrativo',
  loadChildren: ()=> import('./interface/adminstrativo/administrativo.module').then(
  (m)=> m.AdministrativoModule)},
  {path: 'cadastrar-cliente',
  loadChildren: ()=> import('./interface/cadastro/cadastro.module').then(
  (m)=> m.CadastroModule)},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
],
  exports: [RouterModule]
})
export class AppRoutingModule { }
