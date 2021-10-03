import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {User} from "../models/user.model";

@Injectable()
export class AuthService {

  private baseUrl = 'http://localhost:8080/api';
  private currentUser: User;

  constructor(private http: HttpClient) {
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  isAuthenticated(): boolean {
    return !!this.currentUser;
  };

  login(username: string, password: string){
    const url = this.baseUrl + '/login';
    return this.http.post<HttpResponse<any>>(url, {username: username, password: password}, {headers: new HttpHeaders()
        .set('Content-Type', 'application/json'),
      observe: 'response'});
  };

  logout(){
    const url = this.baseUrl + '/logout';
    return this.http.post<HttpResponse<any>>(url, {}, {headers: new HttpHeaders()
        .set('Content-Type', 'application/json'),
      observe: 'response'});
  }

  getUserByUsername(username: string){
    const url = this.baseUrl + '/users';
    return this.http.get<User>(url + "/" + username)
  }

  setCurrentUser(user: User): void {
    this.currentUser = user;
  }

  getCurrentUser(): User {
    return this.currentUser;
  }
}
