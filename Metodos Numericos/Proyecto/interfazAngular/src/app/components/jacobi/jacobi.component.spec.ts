import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JacobiComponent } from './jacobi.component';

describe('JacobiComponent', () => {
  let component: JacobiComponent;
  let fixture: ComponentFixture<JacobiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [JacobiComponent]
    });
    fixture = TestBed.createComponent(JacobiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
