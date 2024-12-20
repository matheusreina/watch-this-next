import { Component, OnInit } from '@angular/core';
import { LanguageService } from '../../services/language.service';
import { TrendingRequestsService } from '../../services/trending-requests.service';
import { MediaComponent } from '../../components/card/media/media.component';
import { ComponentReloadService } from '../../services/component-reload.service';
import { LoadingComponent } from '../../components/misc/loading/loading.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MediaComponent, LoadingComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent implements OnInit {
  trendingList: any[] = [];
  currentLang: string = 'en'; // Default language
  timePeriod = 'day';
  loading: boolean = true;

  // Text Values

  constructor(
    private languageService: LanguageService,
    private trendingService: TrendingRequestsService,
    private reloadService: ComponentReloadService
  ) {}

  ngOnInit(): void {
    this.languageService.currentLanguage$.subscribe((lang) => {
      this.currentLang = lang;
    });
    this.reloadService.reload$.subscribe(() => this.reloadComponent());
    this.changeToDay();
  }

  reloadComponent(): void {
    this.loading = true;
    if (this.timePeriod === 'day') {
      this.changeToDay();
    } else {
      this.changeToWeek();
    }
  }

  changeToWeek(): void {
    this.trendingService.getTendingByWeek().subscribe((data) => {
      this.trendingList = data.results;
    });
    this.timePeriod = 'week';
    this.loading = false;
    this.toggleActive();
  }

  changeToDay(): void {
    this.trendingService.getTendingByDay().subscribe((data) => {
      this.trendingList = data.results;
    });
    this.timePeriod = 'day';
    this.loading = false;
    this.toggleActive();
  }

  toggleActive(): boolean {
    if (this.timePeriod === 'day') {
      return true;
    } else {
      return false;
    }
  }
}
