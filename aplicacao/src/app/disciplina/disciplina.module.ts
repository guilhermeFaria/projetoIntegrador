import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { DisciplinaComponent } from './disciplina.component';
import { DisciplinaService } from '../service/disciplina.service';
import { ProfessorService } from '../service/professor.service';

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [ DisciplinaComponent ],
  providers: [ DisciplinaService, ProfessorService ]
})
export class DisciplinaModule { }
