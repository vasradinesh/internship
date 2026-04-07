import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AdminService {

  private baseUrl = 'http://localhost:8787/admin';

  constructor(private http: HttpClient) { }

  // GET ALL USERS
  getAllUsers() {
    return this.http.get<any[]>(`${this.baseUrl}/users`);
  }


  updateUser(email: string, data: any) {
    return this.http.post(`${this.baseUrl}/update-user-by-email/${email}`, data, {
      responseType: 'text'
    });
  }

  deleteUser(email: string) {
    console.log(email);

    return this.http.delete(`${this.baseUrl}/delete-user-by-email/${email}`, {
      responseType: 'text'
    });
  }

  getUserByEmail(email: string) {
    return this.http.get(`${this.baseUrl}/getUserByEmail/${email}`);
  }

  getAllDonations() {
    return this.http.get<any[]>(this.baseUrl + '/get-all-donation');
  }


  approveDonation(id: number) {
    return this.http.get(`http://localhost:8787/admin/donor/${id}/approve`);
  }

  downloadBloodStockReport() {
    return this.http.get(
      'http://localhost:8787/admin/bloodstockreport/download',
      { responseType: 'blob' }
    );
  }

  downloadRequestReport() {
    return this.http.get(
      'http://localhost:8787/admin/blood/requestdata/download',
      { responseType: 'blob' }
    );
  }

  addBloodStock(stock: any) {
    return this.http.post(`${this.baseUrl}/blood-stock/add`, stock, {
      responseType: 'text'
    });
  }

  // 🔹 GET ALL REQUESTS
  getAllBloodRequests() {
    return this.http.get<any[]>(`${this.baseUrl}/get-all-bloodrequest`);
  }

  approveBloodRequest(id: number) {
    return this.http.get(
      `${this.baseUrl}/bloodrequest/approve/${id}`,
      { responseType: 'text' } // backend returns String
    );
  }

}
