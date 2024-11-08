import { Component, Input } from '@angular/core';
import { ComponentDisplayService } from '../../services/component-display.service';

@Component({
  selector: 'app-person-details',
  standalone: true,
  imports: [],
  templateUrl: './person-details.component.html',
  styleUrl: './person-details.component.css',
})
export class PersonDetailsComponent {
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
