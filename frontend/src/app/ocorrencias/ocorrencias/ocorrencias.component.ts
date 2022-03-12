import { Component, OnInit } from '@angular/core';

import { Faixaetaria } from '../model/faixaetaria';
import { Ocorrencia } from '../model/ocorrencia';
import { Regiao } from '../model/regiao';
import { FaixaEtariaService } from '../service/faixa-etaria.service';
import { OcorrenciaService } from '../service/ocorrencia.service';
import { RegiaoService } from '../service/regiao.service';

@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {

  // Variables
  ocorrencia_exame: Ocorrencia[] = [];
  regiao: Regiao[] = [];
  faixaetaria: Faixaetaria[] = [];

  // Injectable allows us to declare variables inside constructor
  constructor(
    private ocorrenciaService: OcorrenciaService,
    private regiaoService: RegiaoService,
    private faixaEtariaService: FaixaEtariaService
  ) { }
  
  // Initialize component when app starts (Component Lifecycle)
  ngOnInit(): void {
    this.ocorrenciaService.listOcorrencias().subscribe(ocorrencias => {this.ocorrencia_exame = ocorrencias
    });
    this.regiaoService.listRegioes().subscribe(regioes => {this.regiao = regioes});
    this.faixaEtariaService.listFaixaEtaria().subscribe(faixa => {this.faixaetaria = faixa});
  }

}
