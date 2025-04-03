import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PuntoFijoComponent } from './punto-fijo.component';

describe('PuntoFijoComponent', () => {
  let component: PuntoFijoComponent;
  let fixture: ComponentFixture<PuntoFijoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PuntoFijoComponent]
    });
    fixture = TestBed.createComponent(PuntoFijoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
