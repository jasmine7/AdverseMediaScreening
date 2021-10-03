import {Component, OnInit} from '@angular/core';
import {SearchService} from "../../core/services/search.service";
import {Search} from "../../core/models/search.model";
import {Page} from "../custom-pagination/pagination-models/page.model";
import {DateRestrict} from "../../core/models/date-restrict.model";
import {BehaviorSubject} from "rxjs";
import {indicate} from "../../core/operators/operators";
import {CustomPaginationService} from "../custom-pagination/custom-pagination.service";
import {SearchSorting} from "../../core/models/search-sorting.model";

@Component({
  selector: 'app-search-list',
  templateUrl: './search-list.component.html',
  styleUrls: ['./search-list.component.scss']
})
export class SearchListComponent implements OnInit {

  loadingPage$ = new BehaviorSubject<boolean>(false);
  dateRestricts = DateRestrict;
  pageNumber: number = 0;
  pageSize: number = 10;
  searchPage: Page<Search>;
  searchSorting = SearchSorting;
  sorting: SearchSorting = SearchSorting.CREATED_DATE;
  direction: string = "DESC";

  constructor(private searchService: SearchService,
              private paginationService: CustomPaginationService) { }

  ngOnInit(): void {
    this.getPageableSearches();
  }

  getPageableSearches(): void {
    this.searchService.getPageableSearches(this.pageNumber, this.pageSize, this.sorting, this.direction)
      .pipe(
        indicate(this.loadingPage$)
      ).subscribe(
      searchPage => this.searchPage = searchPage
    )
  }

  changeSorting(sorting: SearchSorting){
    if(this.sorting === sorting){
      if(this.direction === 'DESC'){
        this.direction = 'ASC'
      } else {
        this.direction = 'DESC'
      }
    } else {
      this.sorting = sorting;
      if(this.direction === 'DESC'){
        this.direction = 'ASC';
      }
    }
    this.getPageableSearches();
  }

  getFirstPage(): void {
    this.pageNumber = this.paginationService.getFirstPage(this.searchPage).pageNumber;
    this.getPageableSearches();
  }

  getNextPage(): void {
    this.pageNumber = this.paginationService.getNextPage(this.searchPage).pageNumber;
    this.getPageableSearches();
  }

  getPreviousPage(): void {
    this.pageNumber = this.paginationService.getPreviousPage(this.searchPage).pageNumber;
    this.getPageableSearches();
  }

  getLastPage(): void {
    this.pageNumber = this.paginationService.getLastPage(this.searchPage).pageNumber;
    this.getPageableSearches();
  }

  getSpecificPage(pageIndex: number): void {
    this.pageNumber = this.paginationService.getSpecificPage(this.searchPage, pageIndex).pageNumber;
    this.getPageableSearches();
  }
}
