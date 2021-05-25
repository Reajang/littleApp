import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from "./components/home-page/home-page.component";


export const routes: Routes = [
  {
    path: '',
    component: HomePageComponent
  },
  {
    path: 'menu',
    loadChildren: () => import('./components/menu-page/menu-page.module').then(m => m.MenuPageModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(
    routes,
    {
      preloadingStrategy: PreloadAllModules,
      anchorScrolling: 'enabled',
    }
  )],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
