import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItaTacticalReportComponent } from './ita-tactical-report.component';

describe('ItaTacticalReportComponent', () => {
  let component: ItaTacticalReportComponent;
  let fixture: ComponentFixture<ItaTacticalReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItaTacticalReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItaTacticalReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
