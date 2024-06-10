import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Produto } from '../models/produto.model';
import { ProdutoService } from '../services/produto.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-produto',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule, RouterLink],
  templateUrl: './produto.component.html',
  styleUrl: './produto.component.css'
})
export class ProdutoComponent implements OnInit {
  lista: Produto[] = [];
  obj: Produto = new Produto();

  constructor(private api: ProdutoService) {}

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
    .then((produto: any) => {
      alert(produto.produtoNome + " foi adicioando(a) com sucesso!");
      this.consultar();
    });
  }

  excluir(id: number) {
    this.api.excluir(id)
    .toPromise()
    .then( () => {
      alert("Produto excluida com sucesso!");
      this.consultar();
    });
  }

  alterar() {
    this.api.alterar(this.obj.produtoId, this.obj)
    .toPromise()
    .then( () => {
      alert("Produto alterada com sucesso!");
      this.consultar();
    });
  }

  carregarDados(p: Produto) {
    this.obj = p;
  }

  limparDados() {
    this.obj = new Produto();
  }
  
}
