import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {MenuPageComponent} from "./menu-page.component";

export const menuRoutes: Routes = [
  {
    path: '',
    component: MenuPageComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(menuRoutes)],
  exports: [RouterModule]
})
export class MenuPageRoutingModule {
}
