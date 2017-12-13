import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterCheckListByGroupsComponent } from './filter-check-list-by-groups.component';

describe('FilterCheckListByGroupsComponent', () => {
  let component: FilterCheckListByGroupsComponent;
  let fixture: ComponentFixture<FilterCheckListByGroupsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilterCheckListByGroupsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterCheckListByGroupsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
