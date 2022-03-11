import { Component, OnInit } from '@angular/core';
import { Regiao } from '../model/regiao';
import { RegiaoService } from '../service/regiao.service';

@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {

  // Variable
  regioes: Regiao[] = [];

  // Injectable allows us to declare variables inside constructor
  constructor(private regiaoService: RegiaoService) { }

  // Initialize component when app starts (Component Lifecycle)
  ngOnInit(): void {
    this.regioes = this.regiaoService.listRegioes();
  }

}
