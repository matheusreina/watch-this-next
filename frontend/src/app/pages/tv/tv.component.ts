import { Component, OnInit } from '@angular/core';
import { MediaComponent } from '../../components/card/media/media.component';
import { TvRequestsService } from '../../services/tv-requests.service';
import { LanguageService } from '../../services/language.service';
import { ComponentReloadService } from '../../services/component-reload.service';
import { LoadingComponent } from '../../components/misc/loading/loading.component';
import { faL } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-tv',
  standalone: true,
  imports: [MediaComponent, LoadingComponent],
  templateUrl: './tv.component.html',
  styleUrl: './tv.component.scss',
})
export class TvComponent implements OnInit {
  tvList: any[] = [];
  currentLang: string = 'en'; // Default language
  pageSelected: string = 'popular';
  loading: boolean = true;

  constructor(
    private languageService: LanguageService,
    private reloadService: ComponentReloadService,
    private tvService: TvRequestsService
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
    this.tvService.getPopularTv().subscribe((data) => {
      this.tvList = data.results;
    });

    this.pageSelected = 'popular';
    this.loading = false;
  }

  getTopList(): void {
    this.tvService.getTopTv().subscribe((data) => {
      this.tvList = data.results;
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
