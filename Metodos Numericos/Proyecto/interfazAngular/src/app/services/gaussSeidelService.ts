import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GaussSeidel } from '../models/gauss';

@Injectable({
  providedIn: 'root'
})
export class GaussSeidelService {
  private url='http://localhost:5005/gauss-seidel'

  constructor(private http:HttpClient) { }

save(gauss:GaussSeidel): Observable<any> {
  return this.http.post(this.url, gauss);
}

}
