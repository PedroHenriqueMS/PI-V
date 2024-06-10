import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario.model';

const url = 'http://localhost:8080/api/cs/usuarios'
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  consultar(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(url)
  }

  consultarPorId(id: number): Observable<Usuario> {
    const urlLocal = `${url}/${id}`;
    return this.http.get<Usuario>(urlLocal)
  }

  adicionar(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(url, usuario, httpOptions)
  }

  alterar(id: number, usuario: Usuario): Observable<Usuario> {
    const urlLocal = `${url}/${id}`;
    return this.http.put<Usuario>(urlLocal, usuario, httpOptions)
  }

  excluir(id: number): Observable<Usuario> {
    const urlLocal = `${url}/${id}`;
    return this.http.delete<Usuario>(urlLocal, httpOptions)
  }

}
