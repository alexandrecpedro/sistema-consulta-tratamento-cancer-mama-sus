import { Injectable } from '@angular/core';
import { Ocorrencia } from '../model/ocorrencia';

@Injectable({
  providedIn: 'root'
})
export class OcorrenciaService {

  constructor() { }

  // Method to return info
  listOcorrencias(): Ocorrencia[] {
    //const caminho = '/assets/ocorrencias.json';
    const caminho = '/api/ocorrencias'
    return [
      { id: 1, regiao_id: 2, mes: 5, faixa_id: 1, qnt_exames: 44 }
    ];
  };
}
