import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Modelo } from '../models/modelo';

@Injectable({
  providedIn: 'root',
})
export class ModeloService {
  private url = `${environment.base_url}/modelos`;
  private httpHeaders: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  constructor(private http: HttpClient, private router: Router) {}

  getModelos(marca: number): Observable<Modelo[]> {
    return this.http.get<Modelo[]>(`${this.url}/${marca}`).pipe(
      catchError((e) => {
        if (e.status != 401 && e.error.mensaje) {
          this.router.navigate(['/auto']);
          console.error(e.error.mensaje);
        }
        return throwError(e);
      })
    );
  }
}
