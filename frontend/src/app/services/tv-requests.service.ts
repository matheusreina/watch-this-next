import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LanguageService } from './language.service';

@Injectable({
  providedIn: 'root',
})
export class TvRequestsService {
  private readonly apiUrl = 'http://localhost:8080/';

  constructor(
    private http: HttpClient,
    private languageService: LanguageService
  ) {}

  getTopTv(): Observable<any> {
    const language = this.languageService.getLanguage;
    return this.http.get(`${this.apiUrl}${language}/tv/top_rated`);
  }

  getPopularTv(): Observable<any> {
    const language = this.languageService.getLanguage;
    return this.http.get(`${this.apiUrl}${language}/tv/popular`);
  }

  getTvDetails(id: string): Observable<any> {
    const language = this.languageService.getLanguage;
    return this.http.get(`${this.apiUrl}${language}/tv/${id}`);
  }
}
