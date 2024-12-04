import { LanguageService } from './language.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MovieRequestsService {
  private readonly apiUrl = 'http://localhost:8080/';

  constructor(
    private http: HttpClient,
    private languageService: LanguageService
  ) {}

  getTopMovies(): Observable<any> {
    const language = this.languageService.getLanguage();
    return this.http.get(`${this.apiUrl}${language}/movie/top_rated`);
  }

  getPopularMovies(): Observable<any> {
    const language = this.languageService.getLanguage();
    return this.http.get(`${this.apiUrl}${language}/movie/popular`);
  }

  getDetails(id: string): Observable<any> {
    const language = this.languageService.getLanguage();
    return this.http.get(`${this.apiUrl}${language}/movie/${id}`);
  }
}
