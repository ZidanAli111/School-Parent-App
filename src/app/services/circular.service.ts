import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CircularDetails } from '../model/circular-details';

@Injectable({
  providedIn: 'root'
})
export class CircularService {

  constructor(private http: HttpClient) { }

  createCircular(circular:CircularDetails): Observable<Object>{
    return this.http.post('http://localhost:9081/api/circular/get',circular);
  }

  getCirculars():Observable<CircularDetails[]>{
    return this.http.get<CircularDetails[]>('http://localhost:9081/api/circular');

  }
}
