import { TestBed } from '@angular/core/testing';

import { ServiceBooks } from './service-books';

describe('ServiceBooks', () => {
  let service: ServiceBooks;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceBooks);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
