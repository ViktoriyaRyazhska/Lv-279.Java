import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestrespComponent } from './testresp.component';

describe('TestrespComponent', () => {
  let component: TestrespComponent;
  let fixture: ComponentFixture<TestrespComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestrespComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestrespComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
