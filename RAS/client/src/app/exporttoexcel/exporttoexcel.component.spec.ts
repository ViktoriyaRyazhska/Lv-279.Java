import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExporttoexcelComponent } from './exporttoexcel.component';

describe('ExporttoexcelComponent', () => {
  let component: ExporttoexcelComponent;
  let fixture: ComponentFixture<ExporttoexcelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExporttoexcelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExporttoexcelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
