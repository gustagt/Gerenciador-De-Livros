import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RequestLogin } from 'src/app/recursos/modelos/RequestLogin';
import { AlertService } from 'src/app/recursos/servico/alert.service';
import { LoginService } from 'src/app/recursos/servico/usuario.service';

@Component({
  selector: 'app-login-adm',
  templateUrl: './login-adm.component.html',
  styleUrls: ['./login-adm.component.css']
})
export class LoginAdmComponent implements OnInit {

  public requestLogin: RequestLogin;

  constructor(private loginService: LoginService,
    private alertService: AlertService,
    private router: Router) { }

  ngOnInit(): void{
    this.requestLogin = new RequestLogin();
  }

  public doLoginAdm(): void{
    this.loginService.doLoginAdm(this.requestLogin).subscribe((data)=>{
      this.requestLogin.setId(data.teste);
      this.router.navigate(['adm/administrativo'])
    },
    (error) => {
      this.alertService.error("Erro no login")
      console.error(error);
    });
  }

  public loginCliente(): void{
    this.router.navigate([''])
  }

}
