import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Page} from "./pagination-models/page.model";

@Component({
  selector: 'app-custom-pagination',
  templateUrl: './custom-pagination.component.html',
  styleUrls: ['./custom-pagination.component.scss']
})
export class CustomPaginationComponent implements OnInit {

  @Input() page:Page<any>;
  @Output() firstPageEvent = new EventEmitter();
  @Output() nextPageEvent = new EventEmitter();
  @Output() previousPageEvent = new EventEmitter();
  @Output() lastPageEvent = new EventEmitter();
  @Output() specificPageEvent: EventEmitter<number> = new EventEmitter<number>();

  totalPages: number;
  pageIndexes: Array<number>;
  currentSelectedPage: number;

  constructor() { }

  ngOnInit(): void {
    this.totalPages = this.page.totalPages;
    this.pageIndexes = Array(this.page.totalPages).fill(0).map((x, i) => i);
    this.currentSelectedPage = this.page.pageable.pageNumber;
  }

  active(index: number) {
    if(this.currentSelectedPage == index){
      return{
        active: true
      }
    }
  }

  disabled(value: boolean){
    return {
      disabled: value
    }
  }

  hasNextPage(): boolean {
    return this.currentSelectedPage < this.totalPages - 1;
  }

  hasPreviousPage(): boolean {
    return this.currentSelectedPage > 0;
  }

  isFirstPage(): boolean {
    return this.currentSelectedPage === 0;
  }

  isLastPage(): boolean {
    return this.currentSelectedPage === this.totalPages - 1;
  }

  firstPage(): void {
    if(!this.isFirstPage()){
      this.firstPageEvent.emit(null);
    }
  }

  nextPage(): void {
    if(this.hasNextPage()){
      this.nextPageEvent.emit(null);
    }
  }

  previousPage(): void {
    if(this.hasPreviousPage()){
      this.previousPageEvent.emit(null);
    }
  }

  lastPage(): void {
    if(!this.isLastPage()){
      this.lastPageEvent.emit(null);
    }
  }

  specificPage(pageIndex: number): void {
    if(this.currentSelectedPage != pageIndex){
      this.specificPageEvent.emit(pageIndex);
    }
  }

}
