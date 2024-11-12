import { Component, Input, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { LanguageService } from '../../../services/language.service';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';
import { faBookmark } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-media',
  standalone: true,
  imports: [RouterLink, FontAwesomeModule],
  templateUrl: './media.component.html',
  styleUrl: './media.component.scss',
})
export class MediaComponent implements OnInit {
  faStar = faStar; // FA Icon
  faBookmark = faBookmark; // FA Icon

  @Input() posterSrc: string = '';
  @Input() vote: number = 0;
  @Input() title: string = '';
  @Input() date: string = '';
  @Input() mediaId: string = '';
  @Input() mediaType: string = '';

  currentLang: string = 'en'; // Default language

  constructor(private languageService: LanguageService) {}

  ngOnInit(): void {
    this.languageService.currentLanguage$.subscribe((lang) => {
      this.currentLang = lang;
    });
  }
}
