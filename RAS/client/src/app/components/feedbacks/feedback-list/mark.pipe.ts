import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'markFilter'
})
export class MarkPipe implements PipeTransform {
  transform(markArray: any, characteristicId: any): any {
    const resultArray = [];
    if(markArray != null){
      markArray.filter(mark => mark.characteristic.id == characteristicId)
        .forEach(mark => resultArray.push({label: mark.name, value: mark.id}));
      return resultArray;
    }
  }
}
