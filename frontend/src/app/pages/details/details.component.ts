import { Component } from '@angular/core';
import { OverviewComponent } from './overview/overview.component';
import { ImagesComponent } from './images/images.component';
import { VideosComponent } from './videos/videos.component';
import { CastAndCrewComponent } from './cast-and-crew/cast-and-crew.component';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [
    OverviewComponent,
    ImagesComponent,
    VideosComponent,
    CastAndCrewComponent,
  ],
  templateUrl: './details.component.html',
  styleUrl: './details.component.scss',
})
export class DetailsComponent {
  overview: boolean = true;
  images: boolean = false;
  videos: boolean = false;
  castCrew: boolean = false;

  toggleComponent(componentId: string) {
    switch (componentId) {
      case 'overview':
        this.overview = true;
        this.images = false;
        this.videos = false;
        this.castCrew = false;
        break;
      case 'images':
        this.overview = false;
        this.images = true;
        this.videos = false;
        this.castCrew = false;
        break;
      case 'videos':
        this.overview = false;
        this.images = false;
        this.videos = true;
        this.castCrew = false;
        break;
      case 'castCrew':
        this.overview = false;
        this.images = false;
        this.videos = false;
        this.castCrew = true;
        break;

      default:
        break;
    }
  }
}
