import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Igeneric } from './igeneric.interface';

export abstract class GenericService<T, ID> implements Igeneric<T, ID> {
  constructor(
    protected http: HttpClient,
    protected router: Router,
    protected base: string
  ) {}

  save(t: T): Observable<T> {
    return this.http.post(this.base, t).pipe(
      map((response: any) => response.cliente as T),
      catchError((e) => {
        if (e.status === 400 || e.status === 500) {
          return throwError(e);
        }
        console.log(e.error.mensaje);
        return throwError(e);
      })
    );
  }

  update(id: ID, t: T): Observable<T> {
    //return this.http.put<T>(this.base + '/' + id, t, {});
    return this.http.put<T>(`${this.base}/${id}`, t).pipe(
      catchError((e) => {
        if (e.status === 400) {
          return throwError(e);
        }
        console.log(e.error.mensaje);
        return throwError(e);
      })
    );
  }

  findById(id: ID): Observable<T> {
    return this.http.get<T>(`${this.base}/${id}`).pipe(
      catchError((e) => {
        if (e.status === 404) {
          return throwError(e);
        }
        return throwError(e);
      })
    );
  }

  findAll(): Observable<T[]> {
    return this.http.get<T[]>(`${this.base}`).pipe(
      catchError((e) => {
        if (e.status === 404) {
          return throwError(e);
        }
        return throwError(e);
      })
    );
  }

  delete(id: ID): Observable<T> {
    return this.http.delete<T>(`${this.base}/${id}`).pipe(
      catchError((e) => {
        console.log(e.error.mensaje);
        return throwError(e);
      })
    );
  }
}
