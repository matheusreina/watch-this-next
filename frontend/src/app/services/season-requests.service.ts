import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LanguageService } from './language.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SeasonRequestsService {
  private readonly apiUrl = 'http://localhost:8080/';

  constructor(
    private http: HttpClient,
    private languageService: LanguageService
  ) {}

  getSeasons(id: string, seasonNumber: number): Observable<any> {
    const language = this.languageService.getLanguage();
    return this.http.get(
      `${this.apiUrl}${language}/tv/${id}/season-${seasonNumber}`
    );
  }
}
