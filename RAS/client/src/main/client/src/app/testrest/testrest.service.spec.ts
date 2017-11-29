import { TestBed, inject } from '@angular/core/testing';

import { TestrestService } from './testrest.service';

describe('TestrestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TestrestService]
    });
  });

  it('should be created', inject([TestrestService], (service: TestrestService) => {
    expect(service).toBeTruthy();
  }));
});
