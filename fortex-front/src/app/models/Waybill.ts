import { ElementStringValue } from './ElementStringValue';

export class Waybill {
  constructor(
    public id: number,
    public employee: number,
    public name: string,
    public date: Date,
    public elementString: ElementStringValue[]
  ) { }
}
