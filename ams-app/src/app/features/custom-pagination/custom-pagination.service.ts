import {Injectable} from "@angular/core";
import {Page} from "./pagination-models/page.model";
import {Pageable} from "./pagination-models/pageable.model";

@Injectable()
export class CustomPaginationService {

  constructor() {
  }

  public getFirstPage(page: Page<any>): Pageable {
    if(!page.first){
      page.pageable.pageNumber = 0;
    }
    return page.pageable;
  }

  public getNextPage(page: Page<any>): Pageable {
    if(!page.last){
      page.pageable.pageNumber = ++page.pageable.pageNumber;
    }
    return page.pageable;
  }

  public getPreviousPage(page: Page<any>): Pageable {
    if(!page.first){
      page.pageable.pageNumber = --page.pageable.pageNumber;
    }
    return page.pageable;
  }

  public getLastPage(page: Page<any>): Pageable {
    if(!page.last){
      page.pageable.pageNumber = page.totalPages - 1;
    }
    return page.pageable;
  }

  public getSpecificPage(page: Page<any>, pageIndex: number){
    page.pageable.pageNumber = pageIndex;
    return page.pageable;
  }
}
