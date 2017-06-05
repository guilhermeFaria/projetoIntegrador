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
      sessionStorage.removeItem('Authorization');
      sessionStorage.setItem('Authorization', res.headers.get('Token'));
      return res.json();
    });
	}
}