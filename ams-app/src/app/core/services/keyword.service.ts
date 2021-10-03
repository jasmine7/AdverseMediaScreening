import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Keyword} from '../models/keyword.model';
import {catchError} from 'rxjs/operators';

@Injectable()
export class KeywordService {
  private baseUrl = 'http://localhost:8080/api/keywords';

  constructor(private http: HttpClient) {
  }

  getKeywords(): Observable<Keyword[]> {
    return this.http.get<Keyword[]>(this.baseUrl)
      .pipe(
        catchError(this.handleError<Keyword[]>('getKeywords'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T){
    return(error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
