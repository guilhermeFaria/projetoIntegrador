import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Disciplina } from '../model/disciplina';
import { Professor } from '../model/professor';
import { Usuario } from '../model/usuario';
import { Webservice } from '../helpers/webservice';

@Injectable()
export class DisciplinaService {

  constructor(private webservice: Webservice) { }

  buscar(id: number): Observable<Disciplina> {
    return this.webservice.get('disciplina/get/' + id).map(res => res.json());
  }

  buscarPorProfessor(professor: Professor): Observable<Disciplina[]> {
    return this.webservice.get('disciplina/get/professor/' + professor.id).map(res => res.json());
  }

}
