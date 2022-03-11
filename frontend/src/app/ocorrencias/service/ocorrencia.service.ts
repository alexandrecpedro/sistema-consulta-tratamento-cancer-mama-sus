import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Ocorrencia } from '../model/ocorrencia';
@Injectable({
  providedIn: 'root'
})
export class OcorrenciaService {

  constructor(
    private http: HttpClient
  ) { }

  // Method to return info
  listOcorrencias(): Observable<Ocorrencia[]> {
    // const pathURL = '/assets/ocorrencias.json';
    const pathURL = '/api/incidencias';

    return this.http.get<Ocorrencia[]>(pathURL);
    // [
    //   { id: 1, regiao_id: 2, Mes: 5, faixa_id: 1, qnt_exames: 44 }
    // ];
  };
}
