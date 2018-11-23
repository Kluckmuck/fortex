import { ElementString } from './ElementString';

export class Waybill {
  constructor(
    public id: number,
    public employee: number,
    public name: string,
    public date: Date,
    public description: string,
    public elementString: ElementString[]
  ) { }
}
