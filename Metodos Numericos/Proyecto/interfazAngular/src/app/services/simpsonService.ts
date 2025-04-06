import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Simpson } from '../models/Simpson';

@Injectable({
  providedIn: 'root'
})
export class SimpsonService {
  private url='http://localhost:5008/simpson'

  constructor(private http:HttpClient) { }

save(simpson:Simpson): Observable<any> {
  return this.http.post(this.url,simpson);
}

}
