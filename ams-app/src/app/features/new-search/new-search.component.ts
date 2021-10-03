import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {KeywordService} from "../../core/services/keyword.service";
import {Keyword} from "../../core/models/keyword.model";
import {ClientService} from "../../core/services/client.service";
import {Client} from "../../core/models/client.model";
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {SearchService} from "../../core/services/search.service";
import {Search} from "../../core/models/search.model";
import {DateRestrict} from "../../core/models/date-restrict.model";
import {BehaviorSubject, Subject} from "rxjs";
import {indicate} from "../../core/operators/operators";
import {AuthService} from "../../core/services/auth.service";

declare let bootstrap: any;

@Component({
  selector: 'app-new-search',
  templateUrl: './new-search.component.html',
  styleUrls: ['./new-search.component.scss']
})
export class NewSearchComponent implements OnInit {

  @ViewChild('resultModal') resultModal: ElementRef;

  showResultModal: Boolean = false;

  loadingPage$ = new BehaviorSubject<boolean>(false);
  dateRestricts = DateRestrict;
  enumKeys = Object.keys;
  keywords: Keyword[] = [];
  showClient: boolean = false;
  searchForm: FormGroup = this.fb.group({
    user: [this.authService.getCurrentUser()],
    dateRestrict: ['', Validators.required],
    client: [Client, Validators.required],
    keywords: this.fb.array([], Validators.required)
  });
  search: Search;
  searching$ = new Subject<boolean>();

  constructor(private keywordService: KeywordService,
              private clientService: ClientService,
              private searchService: SearchService,
              private authService: AuthService,
              private fb: FormBuilder) { }

  ngOnInit(): void {
    this.getKeywords();
  }

  getKeywords(): void {
    this.keywordService.getKeywords()
      .pipe(
        indicate(this.loadingPage$)
      ).subscribe(keywords => this.keywords = keywords)
  }

  onKeywordCheckboxChange(e): void{
    const checkArray: FormArray = this.searchForm.get('keywords') as FormArray;

    if (e.target.checked) {
      checkArray.push(new FormControl(this.keywords.find(x => x.id == e.target.value)));
    } else (
      checkArray.removeAt(checkArray.controls.findIndex(x => x.value.id == e.target.value))
    )
  }

  doSearch(): void{
    this.showResultModal = true;
    this.searchService.doSearch(this.searchForm.value)
      .pipe(
        indicate(this.searching$)
      ).subscribe(search => {
      this.search = search;
      let bootstrapModal = new bootstrap.Modal(this.resultModal.nativeElement, {
        backdrop: 'static',
        keyboard: false
      });
      bootstrapModal.show();
    })
  }

  searchAgain(): void{
    this.search = null;
    this.showResultModal = false;
  }

  getSelectedClient(client: Client): void{
    this.searchForm.get('client').patchValue(client);
    this.searchForm.patchValue(client);
    this.showClient = true;
  }

}
