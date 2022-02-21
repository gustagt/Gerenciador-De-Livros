import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdministrativoRoutingModule } from './administrativo-routing.module';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { TableModule } from 'primeng/table';
import { InputTextModule } from 'primeng/inputtext';
import { AdminstrativoComponent } from './adminstrativo.component';


@NgModule({
  declarations: [AdminstrativoComponent],
  imports: [
    CommonModule,
    AdministrativoRoutingModule,
    CardModule,
    ButtonModule,
    InputTextModule,
    TableModule,
    FormsModule,
    HttpClientModule
  ]
})
export class AdministrativoModule { }
