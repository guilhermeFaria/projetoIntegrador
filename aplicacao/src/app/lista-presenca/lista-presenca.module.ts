import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Helper } from '../helpers/helper';
import { ListaPresencaService } from '../service/lista-presenca.service';
import { ProfessorService } from '../service/professor.service';
import { DisciplinaService } from '../service/disciplina.service';
import { Webservice } from '../helpers/webservice';

import { ListaPresencaComponent } from './lista-presenca.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  declarations: [ ListaPresencaComponent ],
  providers: [ ListaPresencaService, 
                ProfessorService,
                DisciplinaService,
                Webservice,
                Helper
              ]
})
export class ListaPresencaModule { }
