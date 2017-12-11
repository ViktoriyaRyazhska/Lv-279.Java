import { TestBed, inject } from '@angular/core/testing';

import { MyauthService } from './myauth.service';

describe('AuthService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MyauthService]
    });
  });

  it('should be created', inject([MyauthService], (service: MyauthService) => {
    expect(service).toBeTruthy();
  }));
});
