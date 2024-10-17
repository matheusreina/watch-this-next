import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { MovieTopComponent } from './pages/movie-top/movie-top.component';
import { MoviePopularComponent } from './pages/movie-popular/movie-popular.component';
import { MovieDetailsComponent } from './pages/movie-details/movie-details.component';
import { TvTopComponent } from './pages/tv-top/tv-top.component';
import { TvPopularComponent } from './pages/tv-popular/tv-popular.component';
import { TvDetailsComponent } from './pages/tv-details/tv-details.component';
import { PersonDetailsComponent } from './pages/person-details/person-details.component';

export const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: ':lang/movie/top_rated', component: MovieTopComponent },
    { path: ':lang/movie/popular', component: MoviePopularComponent },
    { path: ':lang/movie/:id', component: MovieDetailsComponent },
    { path: ':lang/tv/top_rated', component: TvTopComponent },
    { path: ':lang/tv/popular', component: TvPopularComponent },
    { path: ':lang/tv/:id', component: TvDetailsComponent },
    { path: ':lang/person/:id', component: PersonDetailsComponent },
];
