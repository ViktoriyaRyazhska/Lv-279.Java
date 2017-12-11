export class UserShort{

  id:number;
  fullName: string;
}

export class UserPage {
  content: UserShort[] = [];
  totalPages: number;
  totalElements: number;
  first: boolean;
  last: boolean;
  numberOfElements: number;
  number: number;
}
