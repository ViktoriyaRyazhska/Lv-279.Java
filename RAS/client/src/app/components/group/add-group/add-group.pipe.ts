import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'profileFilter'
})
export class ProfileInfoFilterPipe implements PipeTransform {

  transform(profileInfoArray: any, directionId: number): any {
    const resultArray = [];
    console.log(directionId);
    // if(directionId == 0){
    //   return profileInfoArray;
    // }
    for (const profileInfo of profileInfoArray) {
      if (profileInfo.technologies.technologyId == directionId) {
        resultArray.push(profileInfo);
      }
    }
    return resultArray;
  }

}
