import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Donor {
  private http = inject(HttpClient);

  private baseUrl = "http://localhost:8787/donor";

  getDonorById(id: any) {
    return this.http.get(`${this.baseUrl}/get-donor-by-id/${id}`);
  }

  saveOrUpdateDonor(data: any) {
    return this.http.post(`${this.baseUrl}/save-or-update-donor`, data);
  }

  donateBlood(data: any) {
    return this.http.post(`${this.baseUrl}/donate`, data);
  }

  getHistory() {
    return this.http.get(`${this.baseUrl}/get-donor-history`);
  }
}
