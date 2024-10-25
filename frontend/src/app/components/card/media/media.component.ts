import { Component, Input, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { LanguageService } from '../../../services/language.service';

@Component({
  selector: 'app-media',
  standalone: true,
  imports: [RouterLink, FontAwesomeModule],
  templateUrl: './media.component.html',
  styleUrl: './media.component.scss',
})
export class MediaComponent implements OnInit {
  @Input() posterSrc: string = '';
  @Input() vote: number = 0;
  @Input() title: string = '';
  @Input() releaseDate = '';
  @Input() mediaId = '';
  @Input() mediaType = '';

  currentLang: string = 'en'; // Default language

  constructor(private languageService: LanguageService) {}

  ngOnInit(): void {
    this.languageService.currentLanguage$.subscribe((lang) => {
      this.currentLang = lang;
    });
  }
}
