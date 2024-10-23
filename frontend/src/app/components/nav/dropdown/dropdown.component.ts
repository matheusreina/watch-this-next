import { Component, ElementRef, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faGlobe } from '@fortawesome/free-solid-svg-icons';
import { LanguageService } from '../../../services/language.service';

@Component({
  selector: 'app-dropdown',
  standalone: true,
  imports: [FontAwesomeModule],
  templateUrl: './dropdown.component.html',
  styleUrl: './dropdown.component.scss',
})
export class DropdownComponent {
  faGlobe = faGlobe;
  isDropdownOpen = false;
  userLanguage = 'en';

  constructor(
    private eRef: ElementRef,
    private router: Router,
    private languageService: LanguageService
  ) {}

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  setUserLanguage(lang: string) {
    this.userLanguage = lang;
    this.isDropdownOpen = false;
    this.switchLanguage(lang);
  }

  @HostListener('document:click', ['$event'])
  clickOut(event: Event) {
    if (!this.eRef.nativeElement.contains(event.target)) {
      this.isDropdownOpen = false;
    }
  }

  switchLanguage(lang: string) {
    this.languageService.setLanguage(lang);
    const currentUrl = this.router.url.split('/')[1];
    //.slice(1);
    // .join('/');
    console.log(currentUrl);
    //this.router.navigate([`/${lang}/${currentUrl}`]);
  }
}
