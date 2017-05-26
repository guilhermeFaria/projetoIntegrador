import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes  }  from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { Erro404Component } from './erro404/erro404.component';
import { CadastroAlunoComponent } from './cadastro-aluno/cadastro-aluno.component';
import { CadastroProfessorComponent } from './cadastro-professor/cadastro-professor.component';
import { CadastroCursoComponent } from './cadastro-curso/cadastro-curso.component';
import { CadastroDisciplinaComponent } from './cadastro-disciplina/cadastro-disciplina.component';
import { ListaPresencaComponent } from './lista-presenca/lista-presenca.component';

const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: '**', component: Erro404Component }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    Erro404Component,
    CadastroAlunoComponent,
    CadastroProfessorComponent,
    CadastroCursoComponent,
    CadastroDisciplinaComponent,
    ListaPresencaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
