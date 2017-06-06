import { Component } from '@angular/core';

import { Presenca } from '../model/presenca';
import { ListaPresencaService } from '../service/lista-presenca.service';

@Component({
  selector: 'app-lista-presenca',
  templateUrl: './lista-presenca.component.html',
  styleUrls: ['./lista-presenca.component.css']
})
export class ListaPresencaComponent {

  presencas: Presenca[];

  constructor(private listaPresencaService: ListaPresencaService) {
    listaPresencaService.listar(1, new Date()).subscribe(presencas => this.presencas = presencas);
  }

}
