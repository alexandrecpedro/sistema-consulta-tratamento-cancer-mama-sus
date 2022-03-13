import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatSortModule } from '@angular/material/sort';
import { MatToolbarModule } from '@angular/material/toolbar';

import { OcorrenciasRoutingModule } from './ocorrencias-routing.module';
import { OcorrenciasComponent } from './ocorrencias/ocorrencias.component';
import { FaixaetariaService } from './service/faixaetaria.service';
import { IncidenciaService } from './service/incidencia.service';
import { RegiaoService } from './service/regiao.service';

@NgModule({
  declarations: [
    OcorrenciasComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    MatCardModule,
    MatSortModule,
    MatToolbarModule,
    OcorrenciasRoutingModule
  ],
  providers: [
    IncidenciaService,
    RegiaoService,
    FaixaetariaService
  ]
})
export class OcorrenciasModule { }
