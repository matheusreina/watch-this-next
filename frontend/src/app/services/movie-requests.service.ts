import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WebApiService {
  private apiUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }
  
  getTopMovies(language: string):Observable<any> {
    return this.http.get(`${this.apiUrl}${language}/movies/top_rated`);
  }

  getPopularMovies(language: string): Observable<any> {
    return this.http.get(`${this.apiUrl}${language}/movies/popular`);
  }

  getMovieDetails(language: string, id: string): Observable<any> {
    return this.http.get(`${this.apiUrl}${language}/movies/${id}`);
  }

}
