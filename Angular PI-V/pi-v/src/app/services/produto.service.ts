import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../models/produto.model';

const url = 'http://localhost:8080/api/cs/produtos'
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http: HttpClient) { }

  consultar(): Observable<Produto[]> {
    return this.http.get<Produto[]>(url)
  }

  consultarPorId(id: number): Observable<Produto> {
    const urlLocal = `${url}/${id}`;
    return this.http.get<Produto>(urlLocal)
  }

  adicionar(produto: Produto): Observable<Produto> {
    return this.http.post<Produto>(url, produto, httpOptions)
  }

  alterar(id: number, produto: Produto): Observable<Produto> {
    const urlLocal = `${url}/${id}`;
    return this.http.put<Produto>(urlLocal, produto, httpOptions)
  }

  excluir(id: number): Observable<Produto> {
    const urlLocal = `${url}/${id}`;
    return this.http.delete<Produto>(urlLocal, httpOptions)
  }

}
