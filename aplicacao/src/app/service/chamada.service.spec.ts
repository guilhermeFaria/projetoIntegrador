import { TestBed, inject } from '@angular/core/testing';

import { ChamadaService } from './chamada.service';

describe('ChamadaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChamadaService]
    });
  });

  it('should be created', inject([ChamadaService], (service: ChamadaService) => {
    expect(service).toBeTruthy();
  }));
});
