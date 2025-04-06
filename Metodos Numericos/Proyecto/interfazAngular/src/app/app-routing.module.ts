import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PuntoFijoComponent } from './components/punto-fijo/punto-fijo.component';
import { BiseccionComponent } from './components/biseccion/biseccion.component';
import { SecanteComponent } from './components/secante/secante.component';
import { JacobiComponent } from './components/jacobi/jacobi.component';
import { NewtonRaphsonComponent } from './components/newton-raphson/newton-raphson.component';
import { GaussSeidelComponent } from './components/gauss-seidel/gauss-seidel.component';
import { SimpsonComponent } from './components/simpson/simpson.component';
import { TrapecioComponent } from './components/trapecio/trapecio.component';
import {CalculatorComponent} from "./components/calculator/calculator.component";

const routes: Routes = [
  { path: 'PuntoFijo', component:PuntoFijoComponent },
  { path: 'Secante', component:SecanteComponent },
  { path: 'Biseccion', component:BiseccionComponent },
  { path: 'Jacobi', component:JacobiComponent },
  { path: 'Gauss', component:GaussSeidelComponent },
  { path: 'NewtonRaphson', component:NewtonRaphsonComponent},
  { path: 'Simpson', component:SimpsonComponent},
  { path: 'Trapecio', component:TrapecioComponent },
  { path: 'calculator', component:CalculatorComponent },

  { path: '**', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
