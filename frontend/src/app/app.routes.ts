import { Route } from '@angular/router';

export const appRoutes: Route[] = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', loadComponent: () => import('./pages/home/home.component').then(c => c.HomeComponent) },
  { path: 'discussions', loadComponent: () => import('./pages/discussions/discussions.component').then(c => c.DiscussionsComponent) },
  { path: 'cookie', loadComponent: () => import('./pages/cookie/cookie.component').then(c => c.CookieComponent) },
  { path: 'settings', loadComponent: () => import('./pages/settings/settings.component').then(c => c.SettingsComponent) },
  { path: '**', redirectTo: '/home' }
];
