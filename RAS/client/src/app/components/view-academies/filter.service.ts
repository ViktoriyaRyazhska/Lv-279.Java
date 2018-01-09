import {Injectable} from '@angular/core';

@Injectable()
export class FilterService {

  constructor() {
  }

  transform(value: any, filterString: any, propName: string): any {
    if (value.length === 0 || filterString === '' || filterString === null || filterString === undefined) {
      return value;
    }
    const resultArray = [];
    for (const item of value) {
      if (typeof filterString === 'string' && item[propName] != null) {
        if (('' + item[propName].toString().toLowerCase()).includes('' + filterString.toLowerCase())) {
          resultArray.push(item);
        }
      } else {
        if (('' + item[propName]).includes('' + filterString)) {
          resultArray.push(item);
        }
      }

    }
    return resultArray;
  }

  transformStartDate(value: any, filterString: Date, filterOption: string, propName: string): any {
    if (value.length === 0 || filterString === null || filterString.toString() === '') {
      return value;
    }
    const resultArray = [];
    if (filterOption === 'Equals') {
      for (const item of value) {
        if ((item[propName]) === ((filterString.getTime()))) {
          resultArray.push(item);
        }
      }
    } else if (filterOption === 'More Than') {
      for (const item of value) {
        if ((item[propName]) >= ((filterString.getTime()))) {
          resultArray.push(item);
        }
      }
    } else {
      for (const item of value) {
        if ((item[propName]) <= ((filterString.getTime()))) {
          resultArray.push(item);
        }
      }
    }
    return resultArray;
  }

  transformEndDate(value: any, filterString: Date, filterOption: string, propName: string): any {
    if (value.length === 0 || filterString === null || filterString.toString() === '') {
      return value;
    }
    const resultArray = [];
    if (filterOption === 'Equals') {
      for (const item of value) {
        if ((item[propName]) === ((filterString.getTime()))) {
          resultArray.push(item);
        }
      }
    } else if (filterOption === 'More Than') {
      for (const item of value) {
        if ((item[propName]) >= ((filterString.getTime()))) {
          resultArray.push(item);
        }
      }
    } else {
      for (const item of value) {
        if ((item[propName]) <= ((filterString.getTime()))) {
          resultArray.push(item);
        }
      }
    }    return resultArray;
  }
}
