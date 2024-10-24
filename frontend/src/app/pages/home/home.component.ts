import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LanguageService } from '../../services/language.service';
import { TrendingRequestsService } from '../../services/trending-requests.service';
import { MediaComponent } from '../../components/card/media/media.component';

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

  constructor(
    private languageService: LanguageService,
    private trendingService: TrendingRequestsService
  ) {}

  ngOnInit(): void {
    this.languageService.currentLanguage$.subscribe((lang) => {
      this.currentLang = lang;
    });
    this.trendingService.getTendingByDay().subscribe((data) => {
      this.trendingList = data.results;
    });
  }
}
