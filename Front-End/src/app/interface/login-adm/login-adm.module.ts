import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginAdmRoutingModule } from './login-adm-routing.module';
import { LoginAdmComponent } from './login-adm.component';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [LoginAdmComponent],
  imports: [
    CommonModule,
    LoginAdmRoutingModule,
    CardModule,
    ButtonModule,
    InputTextModule,
    FormsModule,
    HttpClientModule
  ]
})
export class LoginAdmModule { }
