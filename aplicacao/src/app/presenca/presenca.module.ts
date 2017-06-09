import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PresencaComponent } from './presenca.component';
import { ChamadaService } from '../service/chamada.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [ PresencaComponent ],
  providers: [ ChamadaService ]
})
export class PresencaModule { }
