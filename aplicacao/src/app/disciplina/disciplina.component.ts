import { Component, OnInit } from '@angular/core';

import { Disciplina } from '../model/disciplina';
import { Professor } from '../model/professor';
import { DisciplinaService } from '../service/disciplina.service';
import { ProfessorService } from '../service/professor.service';

@Component({
  selector: 'app-disciplina',
  templateUrl: './disciplina.component.html',
  styleUrls: ['./disciplina.component.css']
})
export class DisciplinaComponent implements OnInit {

  disciplinas: Disciplina[];
  professor: Professor;

  constructor(private disciplinaService: DisciplinaService,
              private professorService: ProfessorService) {
    professorService.buscar().subscribe(prof => {
      this.professor = prof;
      
      disciplinaService.buscarPorProfessor(this.professor).subscribe(disc => {
        this.disciplinas = disc;
      });
    });
  }

  ngOnInit() {
  }

  

}
