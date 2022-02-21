import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminstrativoComponent } from './adminstrativo.component';

const routes: Routes = [{path:'', component: AdminstrativoComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministrativoRoutingModule { }
