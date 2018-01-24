import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'groupNamesFilter'
})
export class GroupNamesFilterPipe implements PipeTransform {

  transform(groupArray: any, endDate: any, commonDirection: any, cityId: any): any {
    if ((endDate === null || endDate === undefined) && (commonDirection === null || commonDirection === undefined)
      && (cityId === null || cityId === undefined)) {
      return groupArray;
    } else {
      if (endDate !== undefined && endDate !== null) {
        groupArray = groupArray.filter(group => group.endDate === endDate);
      }
      if (commonDirection !== undefined && commonDirection !== null) {
        groupArray = groupArray.filter(group => group.directionId === commonDirection);
      }
      if (cityId !== undefined && cityId !== null) {
        groupArray = groupArray.filter(group => group.cityId === cityId);
      }
      return groupArray;
    }

  }

}
