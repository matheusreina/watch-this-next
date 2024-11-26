import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimilarShowsComponent } from './similar-shows.component';

describe('SimilarShowsComponent', () => {
  let component: SimilarShowsComponent;
  let fixture: ComponentFixture<SimilarShowsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SimilarShowsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SimilarShowsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
