import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map, mapTo, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SymptomsService {
  constructor(private httpClient: HttpClient) {}
  baseURI: string = 'http://localhost:8088/ttr';
  drugUri: string = '/detect/drug';
  diseaseUri: string = '';
  result: string[];

  public getRecommendedDrug(diseaseName: string): Observable<string[]> {
    let pprms = new HttpParams();
    pprms = pprms.append('diseaseName', diseaseName);
    return this.httpClient.get<string[]>(this.baseURI + this.drugUri, {
      params: pprms,
    });
  }
}
