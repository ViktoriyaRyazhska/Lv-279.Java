import { TestBed, inject } from '@angular/core/testing';

import { ItaTacticalReportService } from './ita-tactical-report.service';

describe('ItaTacticalReportService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ItaTacticalReportService]
    });
  });

  it('should be created', inject([ItaTacticalReportService], (service: ItaTacticalReportService) => {
    expect(service).toBeTruthy();
  }));
});
