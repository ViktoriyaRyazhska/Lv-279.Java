import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'payment'
})
export class PaymentPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return value == 1 ? "Founded by Softserve" : "Open group";;
  }

}
