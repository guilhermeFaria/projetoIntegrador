import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes  }  from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { Erro404Component } from './erro404/erro404.component';

const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: '**', component: Erro404Component }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    Erro404Component
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
