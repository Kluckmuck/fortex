import { ElementString } from "./ElementString";

export class WaybillForm<T> {
    org: number;
    id: number;
    name: string;
    date: Date;
    elementString: ElementString[]

    constructor(options: {
        org?: number,
        id?: number,
        name?: string,
        date?: Date,
        elementString?: ElementString[]
    } = {}) {
        this.org = options.org;
        this.id = options.id;
        this.name = options.name;
        this.date = options.date;
        this.elementString = options.elementString;
    }
}