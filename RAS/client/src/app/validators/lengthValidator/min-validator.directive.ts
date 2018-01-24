import {Validator, AbstractControl, ValidationErrors, NG_VALIDATORS} from '@angular/forms';
import {Directive, Input} from "@angular/core";

@Directive({
  selector: '[min]',
  providers: [{provide: NG_VALIDATORS, useExisting: MinValidatorDirective, multi: true}]
})
export class MinValidatorDirective implements Validator {
  @Input() min: number;

  constructor() { }

  validate(control: AbstractControl): ValidationErrors {
    const currentValue = control.value;
    const isValid = currentValue > this.min;

    return isValid ? null : {
        min: {
          valid: false
        }
      };
  }
}

