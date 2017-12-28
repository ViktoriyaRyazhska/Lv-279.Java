import { Pipe, PipeTransform } from '@angular/core';
import {Mark} from "../../../models/feedbacks/mark.model";

@Pipe({
  name: 'markNameFilter'
})
export class MarkNamePipe implements PipeTransform {
  transform(markArray: any, characteristicId: any): any {
    const resultArray = [{label: null, value: null}];
    console.log(markArray);
    if(markArray != null){
      markArray.filter(mark => mark.characteristic.id == characteristicId)
        .forEach(mark => resultArray.push({label: mark.name, value: mark.name}));
      console.log(resultArray);
      return resultArray;
    }
  }
}
