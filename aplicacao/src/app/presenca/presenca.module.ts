import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PresencaComponent } from './presenca.component';
import { ChamadaService } from '../service/chamada.service';
import { AlunoService } from '../service/aluno.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [ PresencaComponent ],
  providers: [ ChamadaService, AlunoService ]
})
export class PresencaModule { }
