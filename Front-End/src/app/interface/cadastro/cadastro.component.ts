import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RequestLogin } from 'src/app/recursos/modelos/RequestLogin';
import { AlertService } from 'src/app/recursos/servico/alert.service';
import { LoginService } from 'src/app/recursos/servico/usuario.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {
  public requestLogin: RequestLogin;

  constructor(private loginService: LoginService,
    private alertService: AlertService,
    private router: Router) { }

  ngOnInit(): void {this.requestLogin = new RequestLogin();
  }

  public loginCliente(): void{
    this.router.navigate([''])
  }

  public doCadastrarCliente(): void{
    this.loginService.doCadastroCliente(this.requestLogin).subscribe((data)=>{
      this.alertService.sucess("Sucesso no cadastro")
      this.router.navigate([''])
    },
    (error) => {
      this.alertService.error("Erro no cadastro")
      console.error(error);
    });
  }
}
