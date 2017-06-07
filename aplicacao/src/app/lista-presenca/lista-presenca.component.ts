import { Component } from '@angular/core';

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

  data: Date = new Date(2017, 5, 7);
  disciplina: Disciplina[];
  professor: Professor;
  presencas: Presenca[];

  constructor(private listaPresencaService: ListaPresencaService,
              private professorService: ProfessorService,
              private disciplinaService: DisciplinaService) {
                
        professorService.buscar().subscribe(prof => {
            this.professor = prof;

            disciplinaService.buscarPorProfessor(this.professor).subscribe(disc => {
                this.disciplina = disc;

                listaPresencaService.listar(this.disciplina[0].id, this.data).subscribe(presencas => this.presencas = presencas);
            });
        });

    }

}
