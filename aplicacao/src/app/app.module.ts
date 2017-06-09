import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes  }  from '@angular/router';
import 'rxjs/add/operator/map';

import { LoginModule } from './login/login.module';
import { ChamadaModule } from './chamada/chamada.module';
import { DisciplinaModule } from './disciplina/disciplina.module';
import { PresencaModule } from './presenca/presenca.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { Erro404Component } from './erro404/erro404.component';
import { ChamadaComponent } from './chamada/chamada.component';
import { DisciplinaComponent } from './disciplina/disciplina.component';
import { PresencaComponent } from './presenca/presenca.component';

const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'disciplinas', component: DisciplinaComponent },
  { path: 'chamada/:id_disciplina', component: ChamadaComponent },
  { path: 'presenca', component: PresencaComponent },
  { path: '**', component: Erro404Component }
];

@NgModule({
  declarations: [
    AppComponent,
    Erro404Component
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    LoginModule,
    ChamadaModule,
    DisciplinaModule,
    PresencaModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
