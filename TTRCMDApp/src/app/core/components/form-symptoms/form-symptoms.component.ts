import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SYMPTOMS_CONSTANTS } from '../../constants/symptom-constant';
import { Output, EventEmitter } from '@angular/core';
import { Symptoms } from '../../symptoms';
import { SymptomsService } from '../../services/symptoms.service';

@Component({
  selector: 'app-form-symptoms',
  templateUrl: './form-symptoms.component.html',
  styleUrls: ['./form-symptoms.component.scss'],
})
export class FormSymptomsComponent implements OnInit {
  data: Symptoms;
  myForm: FormGroup = new FormGroup({});
  dropdownicon = 'pi pi-caret-down';
  constants = SYMPTOMS_CONSTANTS;
  symptomData: String;
  constructor(
    private _fb: FormBuilder,
    private symptomsService: SymptomsService
  ) {
    this.buildForm();
  }

  @Output() submitEvent = new EventEmitter<string[]>();

  getFavSoda = () => this.myForm.get('symptoms')?.value;
  ngOnInit(): void {}

  private buildForm(): void {
    this.myForm = this._fb.group({
      symptoms1: ['', Validators.required],
      symptoms2: ['', Validators.required],
      symptoms3: ['', Validators.required],
    });
  }

  submitForm(): void {
    if (this.myForm.valid) {
      this.data.symptom1 = this.myForm.get('symptoms1')?.value.label;
      this.data.symptom3 = this.myForm.get('symptoms2')?.value.label;
      this.data.symptom3 = this.myForm.get('symptoms3')?.value.label;
    }

    this.symptomsService.getRecommendedDrug('Allergy');
    console.log(this.symptomData);
  }

  triggerSymptomsData(result: any) {
    this.submitEvent.emit(result);
  }
}
