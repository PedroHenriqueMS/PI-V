import { TelaPrincipalComponent } from './tela-principal/tela-principal.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteComponent } from './cliente/cliente.component';
import { ProdutoComponent } from './produto/produto.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { LoginComponent } from './login/login.component';
import { NewUserComponent } from './new-user/new-user.component';

export const routes: Routes = [
    {path: "", component: LoginComponent},
    {path: "home", component: TelaPrincipalComponent},
    {path: "cliente", component: ClienteComponent},
    {path: "produto", component: ProdutoComponent},
    {path: "usuario", component: UsuarioComponent},
    {path: "newUser", component: NewUserComponent}
];

export const RoutingModule = RouterModule.forRoot(routes);

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
