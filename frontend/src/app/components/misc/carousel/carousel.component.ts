import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faArrowRight } from '@fortawesome/free-solid-svg-icons';
import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-carousel',
  standalone: true,
  imports: [FontAwesomeModule, RouterModule],
  templateUrl: './carousel.component.html',
  styleUrl: './carousel.component.scss',
})
export class CarouselComponent {
  faArrowRight = faArrowRight;
  faArrowLeft = faArrowLeft;

  // Input
  @Input() data: any;
  @Input() carouselMaxIndex: number = 10;
  @Input() idx = 0;

  // Output
  @Output() carouselStartEmitter = new EventEmitter<number>();
  @Output() carouselEndEmitter = new EventEmitter<number>();

  // Variables
  carouselIndexStart: number = 0;
  carouselIndexEnd: number = 6;

  // Methods
  getPrev() {
    if (this.carouselIndexStart === 0) {
      this.carouselIndexStart = 0;
      this.carouselIndexEnd = 6;
    } else {
      this.carouselIndexStart -= 1;
      this.carouselIndexEnd -= 1;
    }

    this.carouselStartEmitter.emit(this.carouselIndexStart);
    this.carouselEndEmitter.emit(this.carouselIndexEnd);
  }

  getNext() {
    if (this.carouselIndexEnd === this.carouselMaxIndex) {
      this.carouselIndexStart = this.carouselMaxIndex - 1;
    } else {
      this.carouselIndexStart += 1;
      this.carouselIndexEnd += 1;
    }

    this.carouselStartEmitter.emit(this.carouselIndexStart);
    this.carouselEndEmitter.emit(this.carouselIndexEnd);
  }
}
