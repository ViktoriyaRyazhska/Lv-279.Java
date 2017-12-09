import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestsNamesComponent } from './tests-names.component';

describe('TestsNamesComponent', () => {
  let component: TestsNamesComponent;
  let fixture: ComponentFixture<TestsNamesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestsNamesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestsNamesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
