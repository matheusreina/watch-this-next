import { Component, Input } from '@angular/core';
import { ComponentDisplayService } from '../../../services/component-display.service';

@Component({
  selector: 'app-overview',
  standalone: true,
  imports: [],
  templateUrl: './overview.component.html',
  styleUrl: './overview.component.scss',
})
export class OverviewComponent {
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
