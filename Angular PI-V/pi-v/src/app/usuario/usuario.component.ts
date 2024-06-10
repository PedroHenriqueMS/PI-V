import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Usuario } from '../models/usuario.model';
import { UsuarioService } from '../services/usuario.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule, RouterLink],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})
export class UsuarioComponent implements OnInit {
  lista: Usuario[] = [];
  obj: Usuario = new Usuario();

  constructor(private api: UsuarioService) {}

  ngOnInit(): void{
    this.consultar();
  }

  consultar() {
    this.api.consultar()
    .toPromise()
    .then
    ((res: any) => {
      this.lista = res;
    });
  }
  
  adicionar() {
    this.api.adicionar(this.obj)
    .toPromise()
    .then((usuario: any) => {
      alert(usuario.userNome + " foi adicioando(a) com sucesso!");
      this.consultar();
    });
  }

  excluir(id: number) {
    this.api.excluir(id)
    .toPromise()
    .then( () => {
      alert("Usuario excluida com sucesso!");
      this.consultar();
    });
  }

  alterar() {
    this.api.alterar(this.obj.userId, this.obj)
    .toPromise()
    .then( () => {
      alert("Usuario alterada com sucesso!");
      this.consultar();
    });
  }

  carregarDados(u: Usuario) {
    this.obj = u;
  }

  limparDados() {
    this.obj = new Usuario();
  }
  
}
