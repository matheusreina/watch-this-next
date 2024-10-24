import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@Component({
  selector: 'app-media',
  standalone: true,
  imports: [RouterLink, FontAwesomeModule],
  templateUrl: './media.component.html',
  styleUrl: './media.component.scss',
})
export class MediaComponent {
  @Input() posterSrc: string = '';
  @Input() vote: number = 0;
  @Input() title: string = '';
  @Input() releaseDate = '';
}
