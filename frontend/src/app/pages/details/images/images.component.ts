import { Component, Input } from '@angular/core';
import { ComponentDisplayService } from '../../../services/component-display.service';

@Component({
  selector: 'app-images',
  standalone: true,
  imports: [],
  templateUrl: './images.component.html',
  styleUrl: './images.component.css',
})
export class ImagesComponent {
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
