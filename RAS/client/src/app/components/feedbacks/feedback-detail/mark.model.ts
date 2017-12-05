export class Mark {
  id: number;
  characteristic: Characteristic;
  mark: string;

  constructor(id: number, characteristic: Characteristic, mark: string, description: string) {
    this.id = id;
    this.characteristic = characteristic;
    this.mark = mark;
    this.description = description;
  }

  description: string;
}

class Characteristic {
  constructor(public id: number, public name: string) {
  }
}


