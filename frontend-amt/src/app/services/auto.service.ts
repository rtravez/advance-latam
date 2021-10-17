import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Auto } from '../models/auto';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AutoService {
  private url = `${environment.base_url}/autos`;
  
  private httpHeaders: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  constructor(private http: HttpClient, private router: Router) {}

  getAutos(): Observable<Auto[]> {
    return this.http.get<Auto[]>(this.url);
  }

  getAuto(placa: string): Observable<Auto> {
    return this.http.get<Auto>(`${this.url}/${placa}`).pipe(
      catchError((e) => {
        if (e.status != 401 && e.error.mensaje) {
          this.router.navigate(['/auto']);
          console.error(e.error.mensaje);
        }
        return throwError(e);
      })
    );
  }

  public delete(id: number): Observable<Auto> {
    return this.http.delete<Auto>(`${this.url}/${id}`).pipe(
      catchError((e) => {
        console.log(e.error.mensaje);
        return throwError(e);
      })
    );
  }

  public create(auto: Auto): Observable<Auto> {
    return this.http.post(this.url, auto).pipe(
      map((response: any) => response.cliente as Auto),
      catchError((e) => {
        if (e.status === 400 || e.status === 500) {
          return throwError(e);
        }
        console.log(e.error.mensaje);
        return throwError(e);
      })
    );
  }

  public update(auto: Auto): Observable<any> {
    return this.http.put<any>(`${this.url}/${auto.autoId}`, auto).pipe(
      catchError((e) => {
        if (e.status === 400) {
          return throwError(e);
        }
        console.log(e.error.mensaje);
        return throwError(e);
      })
    );
  }
}
