import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PageNotFoundComponent} from "./core/page-not-found/page-not-found.component";
import {LoginComponent} from "./core/login/login.component";
import {AuthGuard} from "./core/guards/auth.guard";


const routes: Routes = [
  {
    path: 'new-search',
    loadChildren: () => import('./features/new-search/new-search.module').then(m => m.NewSearchModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'searches/:id',
    loadChildren: () => import('./features/search-details/search-details.module').then(m => m.SearchDetailsModule),
    canActivate: [AuthGuard]
  },
  {
    path: '',
    loadChildren: () => import('./features/search-list/search-list.module').then(m => m.SearchListModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
