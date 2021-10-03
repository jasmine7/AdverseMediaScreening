import {Component, OnInit} from '@angular/core';
import {Search} from "../../core/models/search.model";
import {SearchService} from "../../core/services/search.service";
import {ActivatedRoute} from "@angular/router";
import {Result} from "../../core/models/result.model";
import {DateRestrict} from "../../core/models/date-restrict.model";
import {BehaviorSubject} from "rxjs";
import {indicate} from "../../core/operators/operators";
import {AuthService} from "../../core/services/auth.service";
import {ToastNotificationService} from "../toast-notification/toast-notification.service";
import {DecisionService} from "../../core/services/decision.service";
import {CreateDecisionList} from "../../core/models/create-decision-list.model";

@Component({
  selector: 'app-search-details',
  templateUrl: './search-details.component.html',
  styleUrls: ['./search-details.component.scss']
})
export class SearchDetailsComponent implements OnInit {

  loadingSearch$ = new BehaviorSubject<boolean>(false);
  loadingResults$ = new BehaviorSubject<boolean>(false)
  dateRestricts = DateRestrict;
  search: Search;
  results: Result[];

  decisions: Map<number, boolean> = new Map<number, boolean>();
  createDecisionList: CreateDecisionList = new CreateDecisionList()

  constructor(private searchService: SearchService,
              private authService: AuthService,
              private route: ActivatedRoute,
              private toastService: ToastNotificationService,
              private decisionService: DecisionService) { }

  ngOnInit(): void {
    this.getSearch();
  }

  getSearch(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.searchService.getSearchById(id).pipe(
      indicate(this.loadingSearch$)
    ).subscribe(search => {
        this.search = search;
        if(search.resultCount > 0){
          this.getResults();
        }
      });
  }

  getResults(): void{
    this.searchService.getResultsBySearchId(this.search.id).pipe(
      indicate(this.loadingResults$)
    ).subscribe(results => this.results = results);
  }

  getCurrentUser(){
    return this.authService.getCurrentUser();
  }

  saveDecisions(){
    this.createDecisionList.user = this.getCurrentUser();

    let convertMap = {};
    this.decisions.forEach(((value, key) => {
      convertMap[key] = value;
    }));
    this.createDecisionList.decisions = convertMap;

    this.decisionService.saveDecisions(this.createDecisionList).subscribe(
      x => {
        this.toastService.createSuccessToast("Result decisions for search "
          + this.search.id
          + " have been saved successfully!", true);
        this.getResults();
        this.decisions.clear();
      }
    )

  }

  changeDecisions(resultId: number, decision: boolean){
    if(decision === null){
      if(this.decisions.has(resultId)){
        this.decisions.delete(resultId);
      }
    } else {
      this.decisions.set(resultId, decision);
    }
  }
}
