import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Helper } from '../helpers/helper';
import { ChamadaService } from '../service/chamada.service';
import { ProfessorService } from '../service/professor.service';
import { DisciplinaService } from '../service/disciplina.service';
import { Webservice } from '../helpers/webservice';

import { ChamadaComponent } from './chamada.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  declarations: [ ChamadaComponent ],
  providers: [ ChamadaService, 
                ProfessorService,
                DisciplinaService,
                Webservice,
                Helper
              ]
})
export class ChamadaModule { }
