import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Cliente } from '../models/cliente.model';
import { ClienteService } from '../services/cliente.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-cliente',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule, RouterLink],
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {
  lista: Cliente[] = [];
  obj: Cliente = new Cliente();

  constructor(private api: ClienteService) {}

  ngOnInit(): void {
    this.consultar();
  }

  consultar() {
    this.api.consultar()
      .toPromise()
      .then((res: any) => {
        this.lista = res;
      });
      console.log(this.lista)
  }

  adicionar() {
    console.log(this.obj)
    this.api.adicionar(this.obj)
      .toPromise()
      .then((cliente: any) => {
        alert(cliente.clienteNome + " foi adicionado(a) com sucesso!");
        this.consultar();
      });
  }

  excluir(id: number) {
    this.api.excluir(id)
      .toPromise()
      .then(() => {
        alert("Cliente excluído com sucesso!");
        this.consultar();
      });
  }

  alterar() {
    this.api.alterar(this.obj.clienteId, this.obj)
      .toPromise()
      .then(() => {
        alert("Cliente alterado com sucesso!");
        this.consultar();
      });
  }

  carregarDados(c: Cliente) {
    this.obj = c;
  }

  limparDados() {
    this.obj = new Cliente();
  }
}
