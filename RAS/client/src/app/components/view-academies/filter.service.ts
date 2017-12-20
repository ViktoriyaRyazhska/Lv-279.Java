import { Injectable } from '@angular/core';

@Injectable()
export class FilterService {

  constructor() { }

  transform(value: any, filterString: string, propName: string): any {
    if (value.length === 0 || filterString === '' || filterString === null) {
      return value;
    }
    const resultArray = [];
    for (const item of value) {
      if (('' + item[propName]).includes('' + filterString)) {
        resultArray.push(item);
      }
    }
    return resultArray;
  }

  transformDate(value: any, filterString: Date, propName: string): any {
    if (value.length === 0 || filterString === null || filterString.toString() === '' ) {
      return value;
    }
    const resultArray = [];
    for (const item of value) {
      if (('' + item[propName]).includes('' + (filterString.getTime()))) {
        resultArray.push(item);
      }
    }
    return resultArray;
  }

}
