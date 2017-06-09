import { Component, OnInit } from '@angular/core';

import { Disciplina } from '../model/disciplina';
import { Aluno } from '../model/aluno';
import { DisciplinaService } from '../service/disciplina.service';
import { AlunoService } from '../service/aluno.service';

@Component({
  selector: 'app-presenca',
  templateUrl: './presenca.component.html',
  styleUrls: ['./presenca.component.css']
})
export class PresencaComponent {

  disciplinas: Disciplina[];
  aluno: Aluno;

  constructor(private disciplinaService: DisciplinaService,
              private alunoService: AlunoService) {

    alunoService.buscar().subscribe(alu => {
      this.aluno = alu;
      
        disciplinaService.buscarPorAluno(this.aluno).subscribe(disc => {
          this.disciplinas = disc;
        });
    });
  }
  

}
