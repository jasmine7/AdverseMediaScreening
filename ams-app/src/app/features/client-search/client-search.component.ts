import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {ClientService} from "../../core/services/client.service";
import {Client} from "../../core/models/client.model";
import {FormControl} from "@angular/forms";
import {debounceTime, distinctUntilChanged, filter, switchMap, map} from "rxjs/operators";
import {AddNewClientComponent} from "../add-new-client/add-new-client.component";

@Component({
  selector: 'app-client-search',
  templateUrl: './client-search.component.html',
  styleUrls: ['./client-search.component.scss']
})
export class ClientSearchComponent implements OnInit {

  @ViewChild('childComponent') childComponent: AddNewClientComponent;

  @Output() selectedClientEvent: EventEmitter<Client> = new EventEmitter<Client>();
  clients: Client[] = [];
  queryField: FormControl = new FormControl();

  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
    this.queryField.valueChanges
      .pipe(
        debounceTime(200),
        distinctUntilChanged(),
        map( (queryField) => {
          if (queryField === '') {
            this.clients = [];
          }
          return queryField;
        }),
        filter(queryField => queryField != ''),
        switchMap( queryField => this.clientService.searchClients(queryField))
      ).subscribe(clients => this.clients = clients)
  }

  selectClient(client: Client){
    this.selectedClientEvent.emit(client);
    this.queryField.patchValue('');
  }

  resetForm(){
    this.childComponent.clientForm.reset();
    this.childComponent.newClient = null;
  }
}
