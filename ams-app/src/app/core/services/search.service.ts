import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Search} from "../models/search.model";
import {catchError} from "rxjs/operators";
import {Page} from "../../features/custom-pagination/pagination-models/page.model";
import {Result} from "../models/result.model";
import {SearchSorting} from "../models/search-sorting.model";

@Injectable()
export class SearchService {
  private baseUrl = 'http://localhost:8080/api/searches';

  constructor(private http: HttpClient) {
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  doSearch(search: any): Observable<Search>{
    return this.http.post<Search>(this.baseUrl, search, this.httpOptions)
      .pipe(
      catchError(this.handleError<Search>('doSearch'))
    );
  }

  getPageableSearches(page: number, size: number, sorting: SearchSorting, direction: string): Observable<Page<Search>>{
    const url = this.baseUrl + '?page=' + page + '&size=' + size + '&sorting=' + sorting + '&direction=' + direction;
    return this.http.get<Page<Search>>(url)
      .pipe(
        catchError(this.handleError<Page<Search>>('getPageableSearches'))
      )
  }

  getSearchById(id: number): Observable<Search>{
    const url = this.baseUrl + '/' + id;
    return this.http.get<Search>(url)
      .pipe(
        catchError(this.handleError<Search>('getSearchById'))
      )
  }

  getResultsBySearchId(id: number): Observable<Result[]>{
    const url = this.baseUrl + '/' + id + '/results';
    return this.http.get<Result[]>(url)
      .pipe(
        catchError(this.handleError<Result[]>('getResultsBySearchId'))
      )
  }

  private handleError<T>(operation = 'operation', result?: T){
    return(error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
