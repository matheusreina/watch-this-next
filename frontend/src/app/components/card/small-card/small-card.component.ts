import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';
import { LanguageService } from '../../../services/language.service';

@Component({
  selector: 'app-small-card',
  standalone: true,
  imports: [RouterLink, FontAwesomeModule],
  templateUrl: './small-card.component.html',
  styleUrl: './small-card.component.scss',
})
export class SmallCardComponent implements OnInit {
  faStar = faStar;
  @Input() id: String = '';
  @Input() poster: String = '';
  @Input() firstInfo: String = '';
  @Input() secondInfo: String = '';
  @Input() routerLink: string = '/en/home';

  currentLang: string = 'en'; // Default language

  constructor(private languageService: LanguageService) {}

  ngOnInit(): void {
    this.languageService.currentLanguage$.subscribe((lang) => {
      this.currentLang = lang;
    });
  }
}
