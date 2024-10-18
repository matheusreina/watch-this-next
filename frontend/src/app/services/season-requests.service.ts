import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SeasonRequestsService {
  private readonly apiUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getSeasons(language: string, id: string) {
    return this.http.get(`${this.apiUrl}${language}/tv/${id}/seasons`);
  }

  getEpisodes(language: string, id: string, seasonNumber: number) {
    return this.http.get(`${this.apiUrl}${language}/tv/${id}/season-${seasonNumber}`);
  }
}
