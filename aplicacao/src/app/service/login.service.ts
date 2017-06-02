import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Webservice } from '../helpers/webservice';
import { Usuario } from '../model/usuario';
import { Login } from '../model/login';

@Injectable()
export class LoginService {

  constructor(private webservice: Webservice) { }
  
  login(login: Login): Observable<Usuario> {
		return this.webservice.post('login', JSON.stringify(login)).map(res => {
      sessionStorage.removeItem('token');
      sessionStorage.setItem('token', res.headers.get("token"));
      console.log(res.headers.get("token"));
      return res.json();
    });
	}
}
