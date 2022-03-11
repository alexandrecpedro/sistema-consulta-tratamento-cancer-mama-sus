import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Regiao } from '../model/regiao';

@Injectable({
  providedIn: 'root'
})
export class RegiaoService {

  constructor(
    private http: HttpClient
  ) { }

  // Observable = particularly of Angular - receiving specific information
  listRegioes(): Observable<Regiao[]> {
    // const path = '/assets/regiao.json';
    const path = '/api/regiao';
    return this.http.get<Regiao[]>(path);
  };
}
