import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { ClienteComponent } from './cliente/cliente.component';
import { ProdutoComponent } from './produto/produto.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { ClienteService } from './services/cliente.service';
import { ProdutoService } from './services/produto.service';
import { UsuarioService } from './services/usuario.service';
import { TelaPrincipalComponent } from './tela-principal/tela-principal.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive, ClienteComponent, ProdutoComponent, UsuarioComponent, TelaPrincipalComponent],
  providers: [ClienteService, ProdutoService, UsuarioService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pi-v';
}
