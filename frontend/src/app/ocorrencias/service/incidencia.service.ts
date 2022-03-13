import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Incidencia } from '../model/incidencia';
@Injectable({
  providedIn: 'root'
})
export class IncidenciaService {

  constructor(
    private http: HttpClient
  ) { }

  // Method to return info
  listOcorrencias(): Observable<Incidencia[]> {
    // const pathURL = '/assets/ocorrencias.json';
    const path = "/api/incidencia";
    return this.http.get<Incidencia[]>(path);
    // [
    //   { id: 1, regiao_id: 2, Mes: 5, faixa_id: 1, qnt_exames: 44 }
    // ];
  };
}
