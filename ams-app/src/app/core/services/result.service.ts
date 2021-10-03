import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Decision} from "../models/decision.model";
import {Observable, of} from "rxjs";
import {catchError} from "rxjs/operators";

@Injectable()
export class ResultService {

  private baseUrl = 'http://localhost:8080/api/results';

  constructor(private http: HttpClient) {
  }

  getDecisionHistoryByResultId(id: number) {
    let url = this.baseUrl + "/" + id + "/decisions";
    return this.http.get<Decision[]>(url)
      .pipe(
        catchError(this.handleError<Decision[]>('getDecisionHistoryByResultId'))
      )
  }

  private handleError<T>(operation = 'operation', result?: T){
    return(error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
