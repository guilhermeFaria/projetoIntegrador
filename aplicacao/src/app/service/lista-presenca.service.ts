import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Webservice } from '../helpers/webservice';
import { Presenca } from '../model/presenca';
import { Usuario } from '../model/usuario';

@Injectable()
export class ListaPresencaService {

  constructor(private webservice: Webservice) {}

    listar(status: boolean): Observable<Presenca[]>  {
        let usuario: Usuario = JSON.parse(sessionStorage.getItem('usuario'));
        let path: string ='lista-presenca/' + usuario.id;

        if(status == null) return this.webservice.get(path)
            .map(res => res.json());

        return this.webservice.get(path + status)
            .map(res => res.json());
    }
  
}
