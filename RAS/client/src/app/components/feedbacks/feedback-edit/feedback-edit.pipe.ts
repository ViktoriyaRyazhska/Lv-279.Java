import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'markFilter'
})
export class FeedbackEditPipe implements PipeTransform {
  transform(markArray: any, characteristicId: any): any {
    const resultArray = [];
    for(const mark of markArray) {
      if(mark.characteristic.id == characteristicId) {
        resultArray.push(mark)
      }
    }
    return resultArray;
  }
}
