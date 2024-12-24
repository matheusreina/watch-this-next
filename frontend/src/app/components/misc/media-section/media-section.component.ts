import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-media-section',
  standalone: true,
  imports: [],
  templateUrl: './media-section.component.html',
  styleUrl: './media-section.component.scss',
})
export class MediaSectionComponent {
  @Input() mediaType: string = '';
  @Input() videoResults: any;
}
