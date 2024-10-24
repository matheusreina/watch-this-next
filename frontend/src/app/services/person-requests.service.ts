import { LanguageService } from './language.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PersonRequestsService {
  private readonly apiUrl = 'http://localhost:8080/';

  constructor(
    private http: HttpClient,
    private languageService: LanguageService
  ) {}

  getPersonDetails(id: string): Observable<any> {
    const language = this.languageService.getLanguage;
    return this.http.get(`${this.apiUrl}${language}/person/${id}`);
  }
}
