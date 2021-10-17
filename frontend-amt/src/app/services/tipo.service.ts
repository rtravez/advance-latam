import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Tipo } from '../models/tipo';

@Injectable({
  providedIn: 'root',
})
export class TipoService {
  private url = `${environment.base_url}/tipos`;
  private httpHeaders: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  constructor(private http: HttpClient, private router: Router) {}

  getTipos(): Observable<Tipo[]> {
    return this.http.get<Tipo[]>(this.url);
  }
}
