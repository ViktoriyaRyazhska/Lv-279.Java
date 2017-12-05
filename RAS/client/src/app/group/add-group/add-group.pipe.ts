import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'profileFilter'
})
export class ProfileInfoFilterPipe implements PipeTransform {

  transform(profileInfoArray: any, directionId: any): any {
    const resultArray = [];
    for (const profileInfo of profileInfoArray) {
      if (profileInfo.technologies.technologyId == directionId) {
        console.log(profileInfo);
        resultArray.push(profileInfo);
      }
    }
    return resultArray;
  }

}
