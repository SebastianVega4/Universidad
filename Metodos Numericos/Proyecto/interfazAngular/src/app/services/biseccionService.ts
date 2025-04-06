import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Biseccion} from '../models/biseccion';

@Injectable({
  providedIn: 'root'
})
export class BiseccionService {
  private url='http://localhost:5001/biseccion'

  constructor(private http:HttpClient) { }

save(biseccion:Biseccion): Observable<any> {
  return this.http.post(this.url, biseccion);
}

}
