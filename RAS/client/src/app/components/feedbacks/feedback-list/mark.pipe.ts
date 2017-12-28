import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'markFilter'
})
export class MarkPipe implements PipeTransform {
  transform(markArray: any, characteristicId: any): any {
    if(markArray != null) {
      return markArray.filter(mark => mark.characteristic.id == characteristicId);
    }
  }
}
