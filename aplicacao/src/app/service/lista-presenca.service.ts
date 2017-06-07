import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Webservice } from '../helpers/webservice';
import { Presenca } from '../model/presenca';
import { Usuario } from '../model/usuario';

@Injectable()
export class ListaPresencaService {

  constructor(private webservice: Webservice) {}

    listar(disciplina: number, data: Date): Observable<Presenca[]>  {
        let usuario: Usuario = JSON.parse(sessionStorage.getItem('usuario'));
        let path: string ='presenca/list/' + disciplina + '/' + data.getTime();

        return this.webservice.get(path)
            .map(res => res.json());
    }
  
}
