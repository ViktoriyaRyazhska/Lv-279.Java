import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'profileFilter'
})
export class ProfileInfoFilterPipe implements PipeTransform {

  transform(profileInfoArray: any, directionId?: number): any {
    if(directionId == null || directionId == 0){
      return [];
    }
    if(profileInfoArray == undefined){
      return [];
    }else {
    return directionId ? profileInfoArray.filter(profileInfo => profileInfo.technologies.technologyId == directionId) : profileInfoArray;}
  }
}
