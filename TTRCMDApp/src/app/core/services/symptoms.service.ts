import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { map, mapTo, Observable } from 'rxjs';
import { Symptoms } from '../symptoms';

@Injectable({
  providedIn: 'root',
})
export class SymptomsService {
  constructor(private httpClient: HttpClient) {}
  baseURI: string =
    'http://proactive-pitches-alb-268165641.eu-central-1.elb.amazonaws.com:';
  drugUri: string = '8088/ttr/detect/drug';
  diseaseUri: string = '5000/predict';
  result: string[];

  public getRecommendedDrug(diseaseName: string): Observable<string[]> {
    console.log(diseaseName);
    const opts = {
      params: new HttpParams({ fromString: 'diseaseName=' + diseaseName }),
    };
    return this.httpClient.get<string[]>(this.baseURI + this.drugUri, opts);
  }
  public getDetectedDisease(symptoms: Symptoms): Observable<string> {
    let pprms = new HttpParams();
    pprms = pprms.append('arg1', symptoms.symptom1);
    pprms = pprms.append('arg2', symptoms.symptom2);
    pprms = pprms.append('arg3', symptoms.symptom3);
    return this.httpClient.get<string>(this.baseURI + this.diseaseUri, {
      params: pprms,
    });
  }

  getClientIp(): Observable<any> {
    return this.httpClient.get('http://api.ipify.org/?format=json');
  }
}
