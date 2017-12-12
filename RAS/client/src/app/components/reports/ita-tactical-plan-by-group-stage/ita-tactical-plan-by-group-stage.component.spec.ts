import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItaTacticalPlanByGroupStageComponent } from './ita-tactical-plan-by-group-stage.component';

describe('ItaTacticalPlanByGroupStageComponent', () => {
  let component: ItaTacticalPlanByGroupStageComponent;
  let fixture: ComponentFixture<ItaTacticalPlanByGroupStageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItaTacticalPlanByGroupStageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItaTacticalPlanByGroupStageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
