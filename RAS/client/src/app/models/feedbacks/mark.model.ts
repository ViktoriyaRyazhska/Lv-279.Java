export class Mark {
  id: number;
  characteristic: Characteristic;
  name: string;

  constructor(id: number, characteristic: Characteristic, name: string, description: string) {
    this.id = id;
    this.characteristic = characteristic;
    this.name = name;
    this.description = description;
  }

  description: string;
}

class Characteristic {
  constructor(public id: number, public name: string) {
  }
}


