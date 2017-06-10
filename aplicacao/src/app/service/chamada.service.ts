import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Webservice } from '../helpers/webservice';
import { Helper } from '../helpers/helper';
import { Disciplina } from '../model/disciplina';
import { Presenca } from '../model/presenca';
import { Usuario } from '../model/usuario';
import { Aluno } from '../model/aluno';

@Injectable()
export class ChamadaService {

  constructor(private webservice: Webservice, private helper: Helper) {}

    listar(disciplina: number, data: Date): Observable<Presenca[]>  {
        let usuario: Usuario = JSON.parse(sessionStorage.getItem('usuario'));
        let path: string ='presenca/get/' + disciplina + '/' + data.getTime();

        return this.webservice.get(path)
            .map(res => res.json());
    }

    getFaltas(aluno: Aluno, disciplina: Disciplina): Observable<number>  {
        let path: string ='presenca/get/faltas/' + aluno.id + '/' + disciplina.id;

        return this.webservice.get(path)
            .map(res => res.json());
    }

    getPresencas(aluno: Aluno, disciplina: Disciplina): Observable<number>  {
        let path: string ='presenca/get/presente/' + aluno.id + '/' + disciplina.id;

        return this.webservice.get(path)
            .map(res => res.json());
    }

    salvar(presencas: Presenca[]): Observable<Presenca[]> {
        presencas.forEach(p => {
            if(p.data) {
                p.data = this.helper.toDate(this.helper.format(p.data));
                p.data.setDate(p.data.getDate() + 1);
            }
        });
        return this.webservice.post('presenca/save', JSON.stringify(presencas)).map(res => {
            console.log(res.json());
            return res.json();
        });
    }
  
}
