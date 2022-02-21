import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RequestLogin } from 'src/app/recursos/modelos/RequestLogin';
import { AlertService } from 'src/app/recursos/servico/alert.service';
import { LoginService } from 'src/app/recursos/servico/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public requestLogin: RequestLogin;


  constructor(
    private loginService: LoginService,
    private alertService: AlertService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.requestLogin = new RequestLogin();
  }

  public doLogin(): void{
    this.loginService.doLogin(this.requestLogin).subscribe((data)=>{
      this.requestLogin.setId(data.teste);
      this.router.navigate(['editar'])
    },
    (error) => {
      this.alertService.error("Erro no login")
      console.error(error);
    });
  }

  public loginAdm(): void{
    this.router.navigate(['login-adm'])
  }

  public cadastrarCliente(): void{
    this.router.navigate(['cadastrar-cliente'])
  }
}
