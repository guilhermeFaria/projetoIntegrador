import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Helper } from '../helpers/helper';
import { Disciplina } from '../model/disciplina';
import { Professor } from '../model/professor';
import { Presenca } from '../model/presenca';
import { ChamadaService } from '../service/chamada.service';
import { ProfessorService } from '../service/professor.service';
import { DisciplinaService } from '../service/disciplina.service';

@Component({
  selector: 'app-chamada',
  templateUrl: './chamada.component.html',
  styleUrls: ['./chamada.component.css']
})
export class ChamadaComponent {

  data: Date = new Date();
  disciplina: Disciplina;
  professor: Professor;
  presencas: Presenca[];

  constructor(private chamadaService: ChamadaService,
              private professorService: ProfessorService,
              private disciplinaService: DisciplinaService,
              private activatedRoute: ActivatedRoute,
              private helper: Helper) {
                
        this.activatedRoute.params.subscribe(params => {
            let id = params['id_disciplina'];

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
        this.chamadaService.listar(this.disciplina.id, this.data).subscribe(presencas => this.presencas = presencas);
    }

    setData(data: string) {
        this.data = this.helper.toDate(data);
        this.listarPresenca();
    }

}
