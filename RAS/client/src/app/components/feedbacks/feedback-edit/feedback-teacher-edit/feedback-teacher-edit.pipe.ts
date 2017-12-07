import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'markFilter'
})
export class FeedbackTeacherDetailPipe implements PipeTransform {
  transform(markArray: any, characteristicId: any): any {
    const resultArray = [];
    for(const mark of markArray) {
      if(mark.characteristic.id == characteristicId) {
        console.log(mark);
        resultArray.push(mark)
      }
    }
    return resultArray;
  }

}
