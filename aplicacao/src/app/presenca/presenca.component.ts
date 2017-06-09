import { Component, OnInit } from '@angular/core';

import { Disciplina } from '../model/disciplina';
import { DisciplinaService } from '../service/disciplina.service';

@Component({
  selector: 'app-presenca',
  templateUrl: './presenca.component.html',
  styleUrls: ['./presenca.component.css']
})
export class PresencaComponent {

  disciplinas: Disciplina[];

  constructor(private disciplinaService: DisciplinaService) { }

  

}
