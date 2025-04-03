import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jacobi } from '../models/jacobi';

@Injectable({
  providedIn: 'root'
})
export class JacobiService {
  private url='http://localhost:5007/jacobi'

  constructor(private http:HttpClient) { }

save(jacobi:Jacobi): Observable<any> {
  return this.http.post(this.url, jacobi);
}

}
