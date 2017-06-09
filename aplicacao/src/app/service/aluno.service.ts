import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Webservice } from '../helpers/webservice';
import { Aluno } from '../model/aluno';
import { Usuario } from '../model/usuario';

@Injectable()
export class AlunoService {

  constructor(private webservice: Webservice) { }

  buscar(): Observable<Aluno> {
    let usuario: Usuario = JSON.parse(sessionStorage.getItem('usuario'));
    return this.webservice.get('aluno/get/usuario/' + usuario.id).map(res => res.json());
  }

}
