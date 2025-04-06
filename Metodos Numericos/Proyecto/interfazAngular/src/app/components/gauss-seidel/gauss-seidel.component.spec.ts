import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GaussSeidelComponent } from './gauss-seidel.component';

describe('GaussSeidelComponent', () => {
  let component: GaussSeidelComponent;
  let fixture: ComponentFixture<GaussSeidelComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GaussSeidelComponent]
    });
    fixture = TestBed.createComponent(GaussSeidelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
