import { Pipe, PipeTransform } from '@angular/core';
import {Mark} from "../../../../models/feedbacks/mark.model";

@Pipe({
  name: 'markFilter'
})
export class FeedbackTeacherEditPipe implements PipeTransform {
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
