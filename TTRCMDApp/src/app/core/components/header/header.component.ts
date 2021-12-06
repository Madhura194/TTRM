import { Component, OnInit } from '@angular/core';
import { SymptomsService } from '../../services/symptoms.service';
import { Symptoms } from '../../symptoms';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  flag: Boolean = false;
  constructor(private symptomsService: SymptomsService) {}
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
    console.log(this.reslt.disease);
    this.gerDrug();
  }

  gerDrug() {
    this.symptomsService
      .getRecommendedDrug(this.reslt.disease)
      .subscribe((res) =>
        res.forEach((r: string) => {
          this.reslt.drug = r;
          console.log(r);
        })
      );
  }
}
