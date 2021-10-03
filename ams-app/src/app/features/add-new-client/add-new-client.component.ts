import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ClientService} from "../../core/services/client.service";
import {Client} from "../../core/models/client.model";
import {BehaviorSubject, Subject} from "rxjs";
import {indicate} from "../../core/operators/operators";

@Component({
  selector: 'app-add-new-client',
  templateUrl: './add-new-client.component.html',
  styleUrls: ['./add-new-client.component.scss']
})
export class AddNewClientComponent implements OnInit {

  clientForm: FormGroup = this.fb.group({
    name: ['', Validators.required],
    type: ['', Validators.required],
    registrationNumber: '',
    country: ['', Validators.required]
  })

  newClient: Client;

  creating$ = new BehaviorSubject<boolean>(false);

  constructor(private fb: FormBuilder,
              private clientService: ClientService) { }

  ngOnInit(): void {
  }

  createClient() {
    if (this.clientForm.controls.registrationNumber.value === '' ||
      this.clientForm.controls.registrationNumber.value === null
    ){
      this.clientForm.controls.registrationNumber.patchValue('n/a');
    }
    this.clientService.createClient(this.clientForm.value)
      .pipe(
        indicate(this.creating$)
      )
      .subscribe(client => {
        this.newClient = client;
        this.clientForm.reset();
      })
  }
}
