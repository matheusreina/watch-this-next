import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LanguageService } from './language.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TrendingRequestsService {
  private readonly apiUrl = 'http://localhost:8080/';

  constructor(
    private http: HttpClient,
    private languageService: LanguageService
  ) {}

  getTendingByDay(): Observable<any> {
    const language = this.languageService.getLanguage();
    return this.http.get(`${this.apiUrl}${language}/trending/all/day`);
  }

  getTendingByWeek(): Observable<any> {
    const language = this.languageService.getLanguage();
    return this.http.get(`${this.apiUrl}${language}/trending/all/week`);
  }
}
