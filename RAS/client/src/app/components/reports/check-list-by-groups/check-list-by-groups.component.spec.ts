import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckListByGroupsComponent } from './check-list-by-groups.component';

describe('CheckListByGroupsComponent', () => {
  let component: CheckListByGroupsComponent;
  let fixture: ComponentFixture<CheckListByGroupsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckListByGroupsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckListByGroupsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
