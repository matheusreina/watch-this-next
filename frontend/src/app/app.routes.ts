import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PersonDetailsComponent } from './pages/person-details/person-details.component';
import { MoviesComponent } from './pages/movies/movies.component';
import { TvComponent } from './pages/tv/tv.component';
import { DetailsComponent } from './pages/details/details.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: navigator.language.startsWith('pt') ? '/pt/home' : '/en/home',
    pathMatch: 'full',
  },
  { path: ':lang/home', component: HomeComponent },
  { path: ':lang/movie', component: MoviesComponent },
  { path: ':lang/tv', component: TvComponent },
  { path: ':lang/:media/:id', component: DetailsComponent },
  { path: ':lang/person/:id', component: PersonDetailsComponent },
  {
    // This 'path' will redirect to any route the user types that does not match with any actual routes bellow:
    path: '**',
    redirectTo: navigator.language.startsWith('pt') ? '/pt/home' : '/en/home',
  },
];
