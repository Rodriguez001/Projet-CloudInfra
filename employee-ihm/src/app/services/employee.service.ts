import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  host_ip: string = window.location.hostname || 'localhost';
  baseUrl: string = 'http://' + this.host_ip + ':8080';

  constructor(private _http: HttpClient) {}

  addEmployee(data: any): Observable<any> {
    return this._http.post(`${this.baseUrl}/employees`, data);
  }

  updateEmployee(id: number, data: any): Observable<any> {
    return this._http.put(`${this.baseUrl}/employee/${id}`, data);
  }

  getEmployeeList(): Observable<any> {
    return this._http.get(`${this.baseUrl}/employees`);
  }

  deleteEmployee(id: number): Observable<any> {
    return this._http.delete(`${this.baseUrl}/employee/${id}`);
  }
}
