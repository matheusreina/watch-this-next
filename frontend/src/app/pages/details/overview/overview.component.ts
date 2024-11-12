import { Component, OnInit } from '@angular/core';
import { TvRequestsService } from '../../../services/tv-requests.service';
import { MovieRequestsService } from '../../../services/movie-requests.service';
import { ComponentReloadService } from '../../../services/component-reload.service';
import { LanguageService } from '../../../services/language.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-overview',
  standalone: true,
  imports: [],
  templateUrl: './overview.component.html',
  styleUrl: './overview.component.scss',
})
export class OverviewComponent implements OnInit {
  currentLang: string = 'en'; // Default language
  data: any;
  dataId: null | string = null;
  dataType: null | string = null;
  loading: boolean = true;

  constructor(
    private languageService: LanguageService,
    private reloadService: ComponentReloadService,
    private route: ActivatedRoute,
    private tvService: TvRequestsService,
    private movieService: MovieRequestsService
  ) {}

  ngOnInit(): void {
    this.languageService.currentLanguage$.subscribe((lang) => {
      this.currentLang = lang;
    });

    const urlSegments = this.route.snapshot.url;
    this.dataType = urlSegments[1].path;
    this.dataId = urlSegments[2].path;

    this.reloadService.reload$.subscribe(() =>
      this.getMediaDetails(this.dataType, this.dataId)
    );

    this.getMediaDetails(this.dataType, this.dataId);
  }

  getMediaDetails(dataType: null | string, dataId: null | string) {
    if (dataType !== null) {
      if (dataId !== null) {
        if (dataType === 'tv') {
          this.tvService.getTvDetails(dataId).subscribe((data) => {
            this.data = data;
          });
        } else {
          this.data = this.movieService
            .getMovieDetails(dataId)
            .subscribe((data) => {
              this.data = data;
            });
        }
      } else {
        // Criar uma pagina 404
      }
    } else {
      // Criar uma pagina 404
    }
    this.loading = false;
  }
}
