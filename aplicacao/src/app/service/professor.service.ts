import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Webservice } from '../helpers/webservice';
import { Professor } from '../model/professor';
import { Usuario } from '../model/usuario';

@Injectable()
export class ProfessorService {

  constructor(private webservice: Webservice) { }

  buscar(): Observable<Professor> {
    let usuario: Usuario = JSON.parse(sessionStorage.getItem('usuario'));
    return this.webservice.get('professor/get/usuario/' + usuario.id).map(res => res.json());
  }

}
