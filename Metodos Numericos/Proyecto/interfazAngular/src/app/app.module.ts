import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PuntoFijoComponent } from './components/punto-fijo/punto-fijo.component';
import { SecanteComponent } from './components/secante/secante.component';
import { NewtonRaphsonComponent } from './components/newton-raphson/newton-raphson.component';
import { BiseccionComponent } from './components/biseccion/biseccion.component';
import { GaussSeidelComponent } from './components/gauss-seidel/gauss-seidel.component';
import { JacobiComponent } from './components/jacobi/jacobi.component';
import { TrapecioComponent } from './components/trapecio/trapecio.component';
import { SimpsonComponent } from './components/simpson/simpson.component';
import { CalculatorComponent } from './components/calculator/calculator.component';


@NgModule({
  declarations: [
    AppComponent,
    PuntoFijoComponent,
    SecanteComponent,
    NewtonRaphsonComponent,
    BiseccionComponent,
    GaussSeidelComponent,
    JacobiComponent,
    TrapecioComponent,
    SimpsonComponent,
    CalculatorComponent
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
