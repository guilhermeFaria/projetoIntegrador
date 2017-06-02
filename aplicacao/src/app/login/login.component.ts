import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Usuario } from '../model/usuario';
import { Login } from '../model/login';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  usuario: Usuario = new Usuario();
  login: Login = new Login();

  constructor(private service: LoginService, private router: Router) {}

  logar(event) {
      event.preventDefault();
      this.service
          .login(this.login)
          .subscribe(usuario => {
              this.usuario = usuario;
              
              if(this.usuario) {
                  sessionStorage.removeItem('usuario');
                  sessionStorage.setItem('usuario', JSON.stringify(this.usuario));
                  if(this.usuario.autorizacoes[0].autorizacao == 'ROLE_ALUNO') {
                	  this.router.navigateByUrl('/presencas');
                  } else {
                    this.router.navigateByUrl('/disciplinas');
                  }
              }

          });
  }

}
