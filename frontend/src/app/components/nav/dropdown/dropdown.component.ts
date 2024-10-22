import { Component } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faGlobe } from '@fortawesome/free-solid-svg-icons';

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

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  setUserLanguage(lang: string) {
    this.userLanguage = lang;
  }
}
