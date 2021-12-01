import { Component, OnInit } from '@angular/core';
import { Symptoms } from '../../symptoms';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  flag: Boolean = false;
  constructor() {}
  reslt: Symptoms = {
    symptom1: '',
    symptom2: '',
    symptom3: '',
    disease: 'Not Detected',
    drug: 'Not detected',
  };
  ngOnInit(): void {}

  getResult(dtd: Symptoms) {
    this.reslt = dtd;
    console.log(this.reslt);
  }
}
