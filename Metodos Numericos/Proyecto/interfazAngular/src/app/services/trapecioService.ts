import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { trapecio } from '../models/trapecio';

@Injectable({
  providedIn: 'root'
})
export class trapecioService {
  private url='http://localhost:5006/Trapecio'

  constructor(private http:HttpClient) { }

save(trapecio:trapecio): Observable<any> {
  return this.http.post(this.url, trapecio);
}

}
