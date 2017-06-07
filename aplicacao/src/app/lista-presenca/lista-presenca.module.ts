import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListaPresencaService } from '../service/lista-presenca.service';
import { ProfessorService } from '../service/professor.service';
import { DisciplinaService } from '../service/disciplina.service';
import { Webservice } from '../helpers/webservice';

import { ListaPresencaComponent } from './lista-presenca.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [ ListaPresencaComponent ],
  providers: [ ListaPresencaService, ProfessorService, DisciplinaService, Webservice ]
})
export class ListaPresencaModule { }
