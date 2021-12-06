import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SYMPTOMS_CONSTANTS } from '../../constants/symptom-constant';
import { Output, EventEmitter } from '@angular/core';
import { Symptoms } from '../../symptoms';
import { SymptomsService } from '../../services/symptoms.service';
import { mapTo } from 'rxjs';

@Component({
  selector: 'app-form-symptoms',
  templateUrl: './form-symptoms.component.html',
  styleUrls: ['./form-symptoms.component.scss'],
})
export class FormSymptomsComponent implements OnInit {
  data: Symptoms = {
    symptom1: '',
    symptom2: '',
    symptom3: '',
    disease: 'Not Detected',
    drug: 'Not detected',
  };
  select1ListModel: string;
  select2ListModel: string;
  select3ListModel: string;
  myForm: FormGroup;
  dropdownicon = 'pi pi-caret-down';
  constants = SYMPTOMS_CONSTANTS.SYMPTOM_LIST;
  symptomData: string[] = [];
  options = {
    symptoms1: this.constants,
    symptoms2: this.constants,
    symptoms3: this.constants,
  };
  @Output() submitEvent = new EventEmitter<Symptoms>();
  constructor(
    private _fb: FormBuilder,
    private symptomsService: SymptomsService
  ) {
    this.buildForm();
  }

  ngOnInit(): void {
    // this.myForm.get('symptoms2').valueChanges.subscribe((symp2) => {
    //   this.getConstants('symptoms2', symp2);
    // });
    // this.myForm.get('symptoms3').valueChanges.subscribe((symp3) => {
    //   this.getConstants('symptoms3', symp3);
    // });
    // this.myForm.get('symptoms1').valueChanges.subscribe((symp1) => {
    //   this.getConstants('symptoms1', symp1);
    // });
  }

  buildForm(): void {
    this.myForm = this._fb.group({
      symptoms1: ['', Validators.required],
      symptoms2: ['', Validators.required],
      symptoms3: ['', Validators.required],
    });
  }

  submitForm(): void {
    this.submitEvent.emit(this.data);
  }

  getDisease() {
    if (this.myForm.valid) {
      this.data.symptom1 = this.myForm.get('symptoms1')?.value.label;
      this.data.symptom2 = this.myForm.get('symptoms2')?.value.label;
      this.data.symptom3 = this.myForm.get('symptoms3')?.value.label;
    }
    this.symptomsService.getDetectedDisease(this.data).subscribe((res) => {
      this.data.disease = res;
      console.log(this.data.disease);
    });
  }

  getValueForDropDown(key) {
    return this.myForm.get(key)?.value;
  }
}
