import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Client} from "../models/client.model";
import {catchError} from "rxjs/operators";

@Injectable()
export class ClientService {
  private baseUrl = 'http://localhost:8080/api/clients';

  constructor(private http: HttpClient) {
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  getClientById(id: number): Observable<Client> {
    const url = this.baseUrl + '/' + id;
    return this.http.get<Client>(url)
      .pipe(
        catchError(this.handleError<Client>('getClientById'))
    )
  }

  searchClients(searchCriteria: string): Observable<Client[]> {
    const url = this.baseUrl + '/search-clients/' + searchCriteria;
    return this.http.get<Client[]>(url)
      .pipe(
        catchError(this.handleError<Client[]>('searchClients'))
      )
  }

  createClient(client: any): Observable<Client>{
    return this.http.post<Client>(this.baseUrl, client, this.httpOptions)
      .pipe(
        catchError(this.handleError<Client>('createClient'))
      )
  }

  private handleError<T>(operation = 'operation', result?: T){
    return(error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
