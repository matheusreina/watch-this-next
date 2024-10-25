import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LanguageService } from '../../services/language.service';
import { TrendingRequestsService } from '../../services/trending-requests.service';
import { MediaComponent } from '../../components/card/media/media.component';
import { MovieRequestsService } from '../../services/movie-requests.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MediaComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent implements OnInit {
  trendingList: any[] = [];
  currentLang: string = 'en'; // Default language

  // Text Values
  timePeriod: string = '';

  constructor(
    private languageService: LanguageService,
    private trendingService: TrendingRequestsService
  ) {}

  ngOnInit(): void {
    this.languageService.currentLanguage$.subscribe((lang) => {
      this.currentLang = lang;
    });
    this.changeToDay();
  }

  changeToWeek(): void {
    this.trendingService.getTendingByWeek().subscribe((data) => {
      this.trendingList = data.results;
    });
    this.timePeriod = 'this week';
  }

  changeToDay(): void {
    this.trendingService.getTendingByDay().subscribe((data) => {
      this.trendingList = data.results;
    });
    this.timePeriod = 'today';
  }
}
