import { TestBed, inject } from '@angular/core/testing';

import { ListaPresencaService } from './lista-presenca.service';

describe('ListaPresencaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListaPresencaService]
    });
  });

  it('should be created', inject([ListaPresencaService], (service: ListaPresencaService) => {
    expect(service).toBeTruthy();
  }));
});
