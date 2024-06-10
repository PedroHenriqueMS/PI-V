import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente.model';

const url = 'http://localhost:8080/api/cs/clientes';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  consultar(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(url);
  }

  consultarPorId(id: number): Observable<Cliente> {
    const urlLocal = `${url}/${id}`;
    return this.http.get<Cliente>(urlLocal);
  }

  adicionar(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(url, cliente, httpOptions);
  }

  alterar(id: number, cliente: Cliente): Observable<Cliente> {
    const urlLocal = `${url}/${id}`;
    return this.http.put<Cliente>(urlLocal, cliente, httpOptions);
  }

  excluir(id: number): Observable<Cliente> {
    const urlLocal = `${url}/${id}`;
    return this.http.delete<Cliente>(urlLocal, httpOptions);
  }
}
