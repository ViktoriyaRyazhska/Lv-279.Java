import {Directive, Input} from '@angular/core';
import {NG_VALIDATORS, Validator, ValidationErrors, AbstractControl, FormControl} from "@angular/forms";
import {Tests} from "../models/tests";

@Directive({
  selector: '[exists]',
  providers: [{provide: NG_VALIDATORS, useExisting: ExistValidatorDirective, multi: true}]
})

export class ExistValidatorDirective implements Validator {
  @Input() exists : Tests[];

  constructor() {
    this.exists = [];
  }

  validate(c: AbstractControl): ValidationErrors {
    const currValue = c.value;
    let isExistNum;
    let seq = [];
    this.exists.forEach(test =>{
      seq.push(test.testSequenceNum);
    });
    let i = seq.indexOf(currValue);
    seq.splice(i,1);
    if(seq.indexOf(currValue)>=0)
    {
       isExistNum = false;
    }
    else isExistNum = true;

    return isExistNum ? null : {
      seqNumbers : {
        valid: false
      }
    };


  }
}

