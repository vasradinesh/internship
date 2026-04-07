import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Auth {
  private baseUrl = "http://localhost:8787/auth";

  constructor(private http: HttpClient) { }


  login(data: any) {
    return this.http.post(`${this.baseUrl}/login`, data);
  }
  register(data: any) {
    return this.http.post(this.baseUrl + '/register', data, {
    responseType: 'text'
  });
  }

  forgotPassword(email: string) {
  return this.http.get(`${this.baseUrl}/${email}`);
}

verifyOtp(data: any) {
  return this.http.post(`${this.baseUrl}/verifyotp`, data);
}

resetPassword(data: any) {
  return this.http.post(`${this.baseUrl}/resetPassword`, data, {
    responseType: 'text' 
  });
}
}
