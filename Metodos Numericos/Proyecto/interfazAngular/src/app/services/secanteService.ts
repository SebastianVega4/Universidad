import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Secante} from '../models/secante';

@Injectable({
  providedIn: 'root'
})
export class SecanteService {
  private url='http://localhost:5002/secante'

  constructor(private http:HttpClient) { }

save(secante:Secante): Observable<any> {
  return this.http.post(this.url, secante);
}

}
