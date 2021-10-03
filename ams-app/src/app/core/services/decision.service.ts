import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Decision} from "../models/decision.model";
import {CreateDecisionList} from "../models/create-decision-list.model";
import {catchError} from "rxjs/operators";

@Injectable()
export class DecisionService {
  private baseUrl = 'http://localhost:8080/api/decisions';

  constructor(private http: HttpClient) {
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  saveDecisions(createDecisionList: CreateDecisionList): Observable<Decision[]>{
    return this.http.post<Decision[]>(this.baseUrl, createDecisionList, this.httpOptions)
      .pipe(
        catchError(this.handleError<Decision[]>('saveDecisions'))
      )
  }

  private handleError<T>(operation = 'operation', result?: T){
    return(error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
