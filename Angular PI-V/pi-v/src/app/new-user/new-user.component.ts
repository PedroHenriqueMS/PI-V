import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Usuario } from '../models/usuario.model';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-new-user',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule, RouterLink],
  templateUrl: './new-user.component.html',
  styleUrl: './new-user.component.css'
})
export class NewUserComponent implements OnInit {
  lista: Usuario[] = [];
  obj: Usuario = new Usuario();

  constructor(private api: UsuarioService) {}

  ngOnInit(): void{
    this.limparDados();
  }

  adicionar() {
    this.api.adicionar(this.obj)
    .toPromise()
    .then((usuario: any) => {
      console.log(usuario)
      alert(usuario.userNome + " foi adicioando(a) com sucesso!");
      this.limparDados();
    });
  }

  limparDados() {
    this.obj = new Usuario();
  }
}
