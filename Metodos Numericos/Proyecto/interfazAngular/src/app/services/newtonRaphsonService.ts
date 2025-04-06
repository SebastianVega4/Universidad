import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NewtonRaphson} from "src/app/models/NewtonRaphson";

@Injectable({
  providedIn: 'root'
})
export class NewtonRaphsonService {
  private url='http://localhost:5000/newton_raphson'

  constructor(private http:HttpClient) { }

  save(newtonRaphson:NewtonRaphson): Observable<any> {
    return this.http.post(this.url, newtonRaphson);
  }

}
