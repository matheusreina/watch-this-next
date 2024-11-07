import { Component, OnInit } from '@angular/core';
import { MediaComponent } from '../../components/card/media/media.component';
import { TvRequestsService } from '../../services/tv-requests.service';
import { LanguageService } from '../../services/language.service';
import { ComponentReloadService } from '../../services/component-reload.service';

@Component({
  selector: 'app-tv',
  standalone: true,
  imports: [MediaComponent],
  templateUrl: './tv.component.html',
  styleUrl: './tv.component.scss',
})
export class TvComponent implements OnInit {
  tvList: any[] = [];
  currentLang: string = 'en'; // Default language
  pageSelected: string = 'popular';

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
  }

  getTopList(): void {
    this.tvService.getTopTv().subscribe((data) => {
      this.tvList = data.results;
    });
    this.pageSelected = 'top rated';
  }

  toggleActive(): boolean {
    if (this.pageSelected === 'popular') {
      return true;
    } else {
      return false;
    }
  }
}
