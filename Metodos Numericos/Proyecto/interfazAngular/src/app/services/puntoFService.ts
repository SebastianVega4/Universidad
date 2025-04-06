import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PuntoF } from '../models/PuntoF';

@Injectable({
  providedIn: 'root'
})
export class PuntoFService {
  private url='http://localhost:5003/punto_fijo'

  constructor(private http:HttpClient) { }

save(puntoF:PuntoF): Observable<any> {
  return this.http.post(this.url, puntoF);
}

}
