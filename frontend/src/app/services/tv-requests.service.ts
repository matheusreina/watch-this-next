import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TvRequestsService {
  private readonly apiUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }
  
  getTopTv(language: string):Observable<any> {
    return this.http.get(`${this.apiUrl}${language}/tv/top_rated`);
  }

  getPopularTv(language: string): Observable<any> {
    return this.http.get(`${this.apiUrl}${language}/tv/popular`);
  }

  getTvDetails(language: string, id: string): Observable<any> {
    return this.http.get(`${this.apiUrl}${language}/tv/${id}`);
  }
}
