import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Empleado } from '../models/empleado';

@Injectable({
  providedIn: 'root',
})
export class EmpleadoService {
  private url = 'http://localhost:1987/api/empleados';
  private httpHeaders: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  constructor(private http: HttpClient, private router: Router) {}

  getEmpleados(): Observable<Empleado[]> {
    return this.http.get<Empleado[]>(this.url);
  }

  getEmpleado(cedula: string): Observable<Empleado> {
    return this.http.get<Empleado>(`${this.url}/${cedula}`).pipe(
      catchError((e) => {
        if (e.status != 401 && e.error.mensaje) {
          this.router.navigate(['/empleado']);
          console.error(e.error.mensaje);
        }
        return throwError(e);
      })
    );
  }

  public delete(id: number): Observable<Empleado> {
    return this.http.delete<Empleado>(`${this.url}/${id}`).pipe(
      catchError((e) => {
        console.log(e.error.mensaje);
        return throwError(e);
      })
    );
  }

  public create(empleado: Empleado): Observable<Empleado> {
    return this.http.post(this.url, empleado).pipe(
      map((response: any) => response.cliente as Empleado),
      catchError((e) => {
        if (e.status === 400) {
          return throwError(e);
        }
        console.log(e.error.mensaje);
        return throwError(e);
      })
    );
  }

  public update(empleado: Empleado): Observable<any> {
    return this.http
      .put<any>(`${this.url}/${empleado.empleadoId}`, empleado)
      .pipe(
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
