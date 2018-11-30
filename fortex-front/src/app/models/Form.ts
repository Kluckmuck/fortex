import { ElementString } from './ElementString';

export class Form {
  constructor(
    public id: number,
    public org: number,
    public name: string,
    public date: Date,
    public elementString: ElementString[]
  ) { }
}
