import { ElementString } from "../ElementString";
import { WaybillForm } from "../WaybillForm";

export class WaybillFormInstance {
    org: number;
    formId: number;
    employeeId: number;
    elementStringValue: ElementString[];

    constructor(form: WaybillForm<any>) {
        this.org = form.org,
        this.formId = form.id,
        this.employeeId = form.id, //ASSIGN USER ID TO THIS
        this.elementStringValue = form.elementString  //NEEDS TO HAVE STRINGINSTANCE HERE SOMEHOW
    } 
    //FIX ABOVE
}

export class StringInstance {
    value: string;
    elementString: StringId[];

    constructor(element: ElementString) {
        this.value = element.value, //CONTAINS VALUE OF FIELD/ELEMENT
        this.elementString = null //SHOULD BE ARRAY CONTAINING ID
    }
}

export class StringId {
    constructor(
        public id: number //CONTAINS ELEMENT ID
    ) {}
}