import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonRequestsService {
  private apiUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getPersonDetails(language: string, id: string): Observable<any> {
    return this.http.get(`${this.apiUrl}${language}/person/${id}`);
  }
}
