import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes  }  from '@angular/router';
import 'rxjs/add/operator/map';

import { LoginModule } from './login/login.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { Erro404Component } from './erro404/erro404.component';
import { ListaPresencaComponent } from './lista-presenca/lista-presenca.component';
import { DisciplinaComponent } from './disciplina/disciplina.component';

const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'disciplinas', component: DisciplinaComponent },
  { path: 'presencas', component: ListaPresencaComponent },
  { path: '**', component: Erro404Component }
];

@NgModule({
  declarations: [
    AppComponent,
    Erro404Component,
    ListaPresencaComponent,
    DisciplinaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    LoginModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
