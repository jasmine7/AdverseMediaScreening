import {Component, ElementRef, EventEmitter, Input, OnDestroy, OnInit, Output, ViewChild} from '@angular/core';
import {Result} from "../../core/models/result.model";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Subscription} from "rxjs";
import {ResultService} from "../../core/services/result.service";
import {Decision} from "../../core/models/decision.model";

declare let bootstrap: any;

@Component({
  selector: 'app-result-details',
  templateUrl: './result-details.component.html',
  styleUrls: ['./result-details.component.scss']
})
export class ResultDetailsComponent implements OnInit, OnDestroy {
  @Input() result: Result;
  @Output() decisionChangeEvent: EventEmitter<boolean> = new EventEmitter<boolean>();

  @ViewChild('historyModal') historyModal: ElementRef;
  bootstrapModal: any;

  private subscription: Subscription;

  changed: boolean = false;
  showHistory: boolean = false;
  form: FormGroup = this.fb.group({
    decision: []
  });
  decisionHistory: Decision[];

  constructor(private fb: FormBuilder,
              private resultService: ResultService) { }

  ngOnInit(): void {
    this.getDecision();
    this.subscription = this.form.get('decision').valueChanges.subscribe(value => {
      if(this.result.decision) {
        if(value === this.result.decision.decision){
          this.changed = false;
          this.decisionChangeEvent.emit(null)
        } else {
          this.changed = true;
          this.decisionChangeEvent.emit(value)
        }
      } else {
        this.changed = true;
        this.decisionChangeEvent.emit(value)
      }
    })
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  getDecision(){
    if(this.result.decision){
      let decision = this.result.decision.decision;
      if(decision){
        this.form.get('decision').setValue(true);
      } else {
        this.form.get('decision').setValue(false);
      }

    }
  }

  showHistoryModal() {
    this.showHistory = true;
    this.resultService.getDecisionHistoryByResultId(this.result.id).subscribe(
      decisions => {
        this.decisionHistory = decisions;
        this.bootstrapModal = new bootstrap.Modal(this.historyModal.nativeElement);
        this.bootstrapModal.show();
      }
    )
  }

  closeHistoryModal() {
    this.bootstrapModal.hide();
    this.showHistory = false;
  }
}
