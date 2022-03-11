import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  // Part 1 - Ocorrencias
  {
    path: '', // default path just redirect to "/ocorrencias"
    pathMatch: 'full', // check if all path is correct, before "/ocorrencias"
    redirectTo: 'ocorrencias'
  },
  // importing secondary module
  {
    path: 'ocorrencias',
    loadChildren: () => import('./ocorrencias/ocorrencias.module').then(m => m.OcorrenciasModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }