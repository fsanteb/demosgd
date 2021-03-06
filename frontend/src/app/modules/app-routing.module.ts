import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {environment} from '../../environments/environment';
import {Page404Component} from '../shared/page404/page404.component';
import {HomeComponent} from '../shared/home/home.component';
import {BandejaComponent} from '../core/bandeja/bandeja.component';
import {DetalleComponent} from '../core/detalle/detalle.component';
import {RegistroComponent} from '../core/registro/registro.component';

export const AppRoutes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'bandeja',
    component: BandejaComponent,
  },
  {
    path: 'detalle/:id',
    component: DetalleComponent,
  },
  {
    path: 'registro',
    component: RegistroComponent,
  },
  {
    path: '**',
    component: Page404Component
  }
];

@NgModule(
  {
    imports: [RouterModule.forRoot(AppRoutes, { enableTracing: false, useHash: false })],
    exports: [RouterModule]
  }
)
export class AppRoutingModule {}
