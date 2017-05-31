import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { LoginComponent } from './login.component';
import { LoginService } from '../service/login.service';
import { Webservice } from '../helpers/webservice';

@NgModule({
  imports: [ CommonModule, FormsModule, RouterModule ],
  declarations: [ LoginComponent ], 
  providers: [ LoginService, Webservice ]
})
export class LoginModule { }
