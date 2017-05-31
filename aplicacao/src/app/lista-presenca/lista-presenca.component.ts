import { Component } from '@angular/core';

import { Presenca } from '../model/presenca';

@Component({
  selector: 'app-lista-presenca',
  templateUrl: './lista-presenca.component.html',
  styleUrls: ['./lista-presenca.component.css']
})
export class ListaPresencaComponent {

  presencas: Presenca[];

  constructor() { }

}
