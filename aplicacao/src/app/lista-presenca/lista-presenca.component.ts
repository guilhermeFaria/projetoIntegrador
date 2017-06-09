import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Helper } from '../helpers/helper';
import { Disciplina } from '../model/disciplina';
import { Professor } from '../model/professor';
import { Presenca } from '../model/presenca';
import { ListaPresencaService } from '../service/lista-presenca.service';
import { ProfessorService } from '../service/professor.service';
import { DisciplinaService } from '../service/disciplina.service';

@Component({
  selector: 'app-lista-presenca',
  templateUrl: './lista-presenca.component.html',
  styleUrls: ['./lista-presenca.component.css']
})
export class ListaPresencaComponent {

  data: Date = new Date();
  disciplina: Disciplina;
  professor: Professor;
  presencas: Presenca[];

  constructor(private listaPresencaService: ListaPresencaService,
              private professorService: ProfessorService,
              private disciplinaService: DisciplinaService,
              private activatedRoute: ActivatedRoute,
              private helper: Helper) {
                
        this.activatedRoute.params.subscribe(params => {
            let id = params['id'];

            if(id) {
                disciplinaService.buscar(id).subscribe(disc => {
                    this.disciplina = disc;
                    this.professor = this.disciplina.professor;

                    this.listarPresenca();
                });
            }
        });

    }

    listarPresenca() {
        this.listaPresencaService.listar(this.disciplina.id, this.data).subscribe(presencas => this.presencas = presencas);
    }

    setData(data: string) {
        this.data = this.helper.toDate(data);
        this.listarPresenca();
    }

}
