import { Component } from '@angular/core';
import { OverviewComponent } from './overview/overview.component';
import { ImagesComponent } from './images/images.component';
import { VideosComponent } from './videos/videos.component';
import { PersonDetailsComponent } from '../person-details/person-details.component';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [
    OverviewComponent,
    ImagesComponent,
    VideosComponent,
    PersonDetailsComponent,
  ],
  templateUrl: './details.component.html',
  styleUrl: './details.component.scss',
})
export class DetailsComponent {}
