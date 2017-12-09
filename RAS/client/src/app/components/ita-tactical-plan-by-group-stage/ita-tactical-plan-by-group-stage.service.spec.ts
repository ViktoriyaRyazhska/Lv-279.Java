import { TestBed, inject } from '@angular/core/testing';

import { ItaTacticalPlanByGroupStageService } from './ita-tactical-plan-by-group-stage.service';

describe('ItaTacticalPlanByGroupStageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ItaTacticalPlanByGroupStageService]
    });
  });

  it('should be created', inject([ItaTacticalPlanByGroupStageService], (service: ItaTacticalPlanByGroupStageService) => {
    expect(service).toBeTruthy();
  }));
});
