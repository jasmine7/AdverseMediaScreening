import {KeywordService} from "./keyword.service";
import {Keyword} from "../models/keyword.model";
import {of} from "rxjs";

describe('KeywordService', () => {
  let keywordService: KeywordService;
  let httpClientSpy: {get: jasmine.Spy}

  beforeEach(() => {
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    keywordService = new KeywordService(httpClientSpy as any);
  })

  it('should return expected keywords (HttpClient called once)', (done: DoneFn) => {
    const expectedKeywords: Keyword[] = [{id: 1, name: 'fraud'}, {id: 2, name: 'crime'}];
    httpClientSpy.get.and.returnValue(of(expectedKeywords));

    keywordService.getKeywords().subscribe(
      keywords => {
        expect(keywords).toEqual(expectedKeywords, 'expected keywords');
        done();
      },
      done.fail
    );
    expect(httpClientSpy.get.calls.count()).toBe(1, 'one call');
  })

})
