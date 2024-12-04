import { Component, OnDestroy, OnInit } from '@angular/core';
import { TvRequestsService } from '../../../services/tv-requests.service';
import { MovieRequestsService } from '../../../services/movie-requests.service';
import { ComponentReloadService } from '../../../services/component-reload.service';
import { LanguageService } from '../../../services/language.service';
import { ActivatedRoute } from '@angular/router';
import { LoadingComponent } from '../../../components/misc/loading/loading.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';
import { faArrowRight } from '@fortawesome/free-solid-svg-icons';
import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';
import { CarouselComponent } from '../../../components/misc/carousel/carousel.component';
import { Subject, takeUntil } from 'rxjs';
import { SmallCardComponent } from '../../../components/card/small-card/small-card.component';

@Component({
  selector: 'app-overview',
  standalone: true,
  imports: [
    LoadingComponent,
    FontAwesomeModule,
    CarouselComponent,
    SmallCardComponent,
  ],
  templateUrl: './overview.component.html',
  styleUrl: './overview.component.scss',
})
export class OverviewComponent implements OnInit, OnDestroy {
  private unsubscribe$ = new Subject<void>();

  currentLang: string = 'en'; // Default language
  data: any;
  dataId: null | string = null;
  dataType: null | string = null;
  loading: boolean = true;

  // Carousel Variables
  carouselRecmmdMaxIndex: number = 10;
  carouselRecmmdIndexStart: number = 0;
  carouselRecmmdIndexEnd: number = 6;
  carouselCreditsMaxIndex: number = 10;
  carouselCreditsIndexStart: number = 0;
  carouselCreditsIndexEnd: number = 6;

  // FA Icon
  faStar = faStar;
  faArrowRight = faArrowRight;
  faArrowLeft = faArrowLeft;

  // Plain text translation variables
  overview: string = '';
  sectionCredits: string = '';
  sectionRecommendations = '';

  getTexts() {
    this.overview = this.currentLang === 'en' ? 'Overview' : 'Descrição';
    this.sectionCredits =
      this.currentLang === 'en' ? 'Top Billed Cast' : 'Elenco Principal';
    this.sectionRecommendations =
      this.currentLang === 'en' ? 'Recommendations' : 'Recomendações';
  }

  constructor(
    private languageService: LanguageService,
    private reloadService: ComponentReloadService,
    private route: ActivatedRoute,
    private tvService: TvRequestsService,
    private movieService: MovieRequestsService
  ) {}

  ngOnInit(): void {
    this.languageService.currentLanguage$
      .pipe(takeUntil(this.unsubscribe$))
      .subscribe((lang) => {
        this.currentLang = lang;
        this.getTexts();
      });

    this.route.params.subscribe((params) => {
      this.dataType = params['media'];
      this.dataId = params['id'];
      this.getMediaDetails(this.dataType, this.dataId);
    });

    this.reloadService.reload$.subscribe(() =>
      this.getMediaDetails(this.dataType, this.dataId)
    );
  }

  ngOnDestroy(): void {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  getMediaDetails(dataType: null | string, dataId: null | string) {
    if (!dataType || !dataId) {
      this.redirectTo404();
      return;
    }

    this.loading = true;

    const service = dataType === 'tv' ? this.tvService : this.movieService;

    service
      .getDetails(dataId)
      .pipe(takeUntil(this.unsubscribe$))
      .subscribe({
        next: (data) => {
          this.data = data;
          this.carouselRecmmdMaxIndex =
            data?.recommendations?.results?.length || 0;
          this.loading = false;
        },
        error: () => {
          this.redirectTo404();
        },
      });
  }

  redirectTo404() {}

  // Carosel Event Emitters
  carouselEventRecmmdStartHandler(event: number) {
    this.carouselRecmmdIndexStart = event;
  }

  carouselEventRecmmdEndHandler(event: number) {
    this.carouselRecmmdIndexEnd = event;
  }

  carouselEventCreditsStartHandler(event: number) {
    this.carouselCreditsIndexStart = event;
  }

  carouselEventCreditsEndHandler(event: number) {
    this.carouselCreditsIndexEnd = event;
  }
}
