import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CardModule } from 'primeng/card';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ButtonModule } from 'primeng/button';
import { LoginComponent } from './interface/login/login.component';
import {InputTextModule} from 'primeng/inputtext';
import { CadastroComponent } from './interface/cadastro/cadastro.component';
import { AdminstrativoComponent } from './interface/adminstrativo/adminstrativo.component';
import {TableModule} from 'primeng/table';
import { ClienteComponent } from './interface/cliente/cliente.component';
import { CadastroLivroComponent } from './interface/cadastro-livro/cadastro-livro.component';
import { LoginAdmComponent } from './interface/login-adm/login-adm.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    
    ClienteComponent,
    CadastroLivroComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    CardModule,
    ButtonModule,
    InputTextModule,
    TableModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
