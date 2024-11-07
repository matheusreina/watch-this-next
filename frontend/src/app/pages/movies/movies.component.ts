import { Component, OnInit } from '@angular/core';
import { LanguageService } from '../../services/language.service';
import { ComponentReloadService } from '../../services/component-reload.service';
import { MediaComponent } from '../../components/card/media/media.component';
import { MovieRequestsService } from '../../services/movie-requests.service';
import { LoadingComponent } from '../../components/misc/loading/loading.component';

@Component({
  selector: 'app-movies',
  standalone: true,
  imports: [MediaComponent, LoadingComponent],
  templateUrl: './movies.component.html',
  styleUrl: './movies.component.scss',
})
export class MoviesComponent implements OnInit {
  movieList: any[] = [];
  currentLang: string = 'en'; // Default language
  pageSelected = 'popular';
  loading: boolean = true;

  constructor(
    private languageService: LanguageService,
    private reloadService: ComponentReloadService,
    private movieService: MovieRequestsService
  ) {}

  ngOnInit(): void {
    this.languageService.currentLanguage$.subscribe((lang) => {
      this.currentLang = lang;
    });
    this.reloadService.reload$.subscribe(() => this.reloadComponent());
    this.getPopularList();
  }

  reloadComponent(): void {
    this.loading = true;
    if (this.pageSelected === 'popular') {
      this.getPopularList();
    } else {
      this.getTopList();
    }
  }

  getPopularList(): void {
    this.movieService.getPopularMovies().subscribe((data) => {
      this.movieList = data.results;
    });
    this.pageSelected = 'popular';
    this.loading = false;
  }

  getTopList(): void {
    this.movieService.getTopMovies().subscribe((data) => {
      this.movieList = data.results;
    });
    this.pageSelected = 'top rated';
    this.loading = false;
  }

  toggleActive(): boolean {
    if (this.pageSelected === 'popular') {
      return true;
    } else {
      return false;
    }
  }
}
