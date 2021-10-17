import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Marca } from '../models/marca';

@Injectable({
  providedIn: 'root',
})
export class MarcaService {
  private url = `${environment.base_url}/marcas`;
  private httpHeaders: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  constructor(private http: HttpClient, private router: Router) {}

  getMarcas(tipo: number): Observable<Marca[]> {
    return this.http.get<Marca[]>(`${this.url}/${tipo}`).pipe(
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
