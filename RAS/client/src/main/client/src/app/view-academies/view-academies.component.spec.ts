import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAcademiesComponent } from './view-academies.component';

describe('ViewAcademiesComponent', () => {
  let component: ViewAcademiesComponent;
  let fixture: ComponentFixture<ViewAcademiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAcademiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAcademiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
