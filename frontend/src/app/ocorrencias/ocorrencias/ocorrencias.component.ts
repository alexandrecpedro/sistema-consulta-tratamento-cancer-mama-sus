import { Component, OnInit } from '@angular/core';

import { Faixaetaria } from '../model/faixaetaria';
import { Incidencia } from '../model/incidencia';
import { Regiao } from '../model/regiao';
import { FaixaetariaService } from '../service/faixaetaria.service';
import { IncidenciaService } from '../service/incidencia.service';
import { RegiaoService } from '../service/regiao.service';

@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {

  // Variables
  incidencia: Incidencia[] = [];
  regiao: Regiao[] = [];
  faixaetaria: Faixaetaria[] = [];

  // Injectable allows us to declare variables inside constructor
  constructor(
    private incidenciaService: IncidenciaService,
    private regiaoService: RegiaoService,
    private faixaEtariaService: FaixaetariaService
  ) { }
  
  // Initialize component when app starts (Component Lifecycle)
  ngOnInit(): void {
    this.incidenciaService.listOcorrencias().subscribe(incidencias => {this.incidencia = incidencias
    });
    this.regiaoService.listRegioes().subscribe(regioes => {this.regiao = regioes});
    this.faixaEtariaService.listFaixaEtaria().subscribe(faixaEtaria => {this.faixaetaria = faixaEtaria});
  }

}
