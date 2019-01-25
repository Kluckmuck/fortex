import { Component, Input } from '@angular/core';
import { ElementString } from 'src/app/models/ElementString';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-form-element',
  templateUrl: './form-element.component.html',
  styleUrls: ['./form-element.component.scss']
})
export class FormElementComponent {
  @Input() element: ElementString;
  @Input() formGroup: FormGroup;
  get isValid() { return this.formGroup.controls[this.element.id].valid; }
}


