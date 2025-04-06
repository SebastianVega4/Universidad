import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BiseccionComponent } from './biseccion.component';

describe('BiseccionComponent', () => {
  let component: BiseccionComponent;
  let fixture: ComponentFixture<BiseccionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BiseccionComponent]
    });
    fixture = TestBed.createComponent(BiseccionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
