import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../services/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Subject} from "rxjs";
import {indicate} from "../operators/operators";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: FormGroup = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
  })

  loggingIn$ = new Subject<boolean>();

  returnUrl: string;

  constructor(private fb: FormBuilder,
              private authService: AuthService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  login(){
    let username = this.form.value.username;
    let password = this.form.value.password;

    if(username && password){
      this.authService.login(username, password)
        .pipe(
          indicate(this.loggingIn$)
        ).subscribe(
          response => {
            this.authService.getUserByUsername(username)
              .pipe(indicate(this.loggingIn$))
              .subscribe(
              user => {
                this.authService.setCurrentUser(user);
                this.router.navigateByUrl(this.returnUrl);
              }
            )
          }
        )
    }
  }


}
