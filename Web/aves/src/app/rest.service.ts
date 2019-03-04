import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http: HttpClient) { }
}

const endpoint = 'http://localhost:8080/datos/aves/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

private extractData(res: Response) {
  let body = res;
  return body || { };
}

getAves(): Observable<any> {
  return this.http.get(endpoint + 'lista').pipe(
    map(this.extractData));
}

/*private handleError<T> (operation = 'operacion', result?: T) {
  return (error: any): Observable<T> => {
    
    console.error(error); // log to console instead

    // convertir error
    console.log('${operacion} fallida: ${error.message}');

    //Continuar al tener mensajes nulos.
    return of(result as T);
  };*/
}