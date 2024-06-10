import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Usuario } from '../models/usuario.model';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  lista: Usuario[] = [];
  obj: Usuario = new Usuario();

  constructor(private api: UsuarioService, private router: Router) { }

  ngOnInit(): void {
    this.consultar();
  }

  consultar() {
    this.api.consultar()
      .toPromise()
      .then
      ((res: any) => {
        this.lista = res;
        console.log(this.lista);
      });
  }

  // Função para validar usuário
  validarUsuario() {
    const login = this.obj.userEmail;
    const senha = this.obj.userSenha;
    console.log(this.obj);
    let usuarioEncontrado = false;

    for (const usuario of this.lista) {
      if (usuario.userEmail === login) {
        usuarioEncontrado = true;
        if (usuario.userSenha === senha) {
          this.router.navigate(['/home']);
          return;
        }
      }
    }

    if (!usuarioEncontrado) {
      alert("Usuário inválido!");
    } else {
      alert("Senha inválida!");
    }
  }
}

