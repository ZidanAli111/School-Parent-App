import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ParentDetails } from '../model/parent-details';
@Injectable({
  providedIn: 'root'
})
export class StudentService {

  // private baseURL="http://localhost:9081/api/parent";
  constructor(private http: HttpClient) { }

  getStudentList(): Observable<ParentDetails[]> {
    return this.http.get<ParentDetails[]>('http://localhost:9081/api/parent/allParents');
  }

  registerStudent(student: ParentDetails): Observable<Object> {
    return this.http.post('http://localhost:9081/api/parent', student);
  }

  getStudentById(parentId: number): Observable<ParentDetails> {
    return this.http.get<ParentDetails>('http://localhost:9081/api/parent/'+parentId);
  }

  updateStudent(parentId:number, student:ParentDetails):Observable<Object>{
    return this.http.put('http://localhost:9081/api/parent/'+parentId,student);
  }
}
