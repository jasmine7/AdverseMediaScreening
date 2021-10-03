import {Pageable} from "./pageable.model";
import {Sort} from "./sort.model";

export class Page<T> {
  content: Array<T>;
  pageable: Pageable;
  totalPages: number;
  last: boolean;
  totalElements: number;
  numberOfElements: number;
  first: boolean;
  sort: Sort;
  size: number;
  number: number;
  empty: boolean;
}
