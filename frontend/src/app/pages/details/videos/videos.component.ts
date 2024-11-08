import { Component, Input } from '@angular/core';
import { ComponentDisplayService } from '../../../services/component-display.service';

@Component({
  selector: 'app-videos',
  standalone: true,
  imports: [],
  templateUrl: './videos.component.html',
  styleUrl: './videos.component.css',
})
export class VideosComponent {
  @Input() id!: string;

  constructor(private displayService: ComponentDisplayService) {}

  getIsOpen() {
    return this.displayService.isComponentOpen(this.id);
  }

  toggleComponent() {
    if (this.getIsOpen()) {
      this.displayService.closeComponent();
    } else {
      this.displayService.setOpenComponentId(this.id);
    }
  }
}
