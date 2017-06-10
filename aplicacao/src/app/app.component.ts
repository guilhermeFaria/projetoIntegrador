import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';
  
  constructor(private router: Router) {}

  logado(): boolean {
    return sessionStorage.getItem('usuario') != null;
  }
  logout(event) {
      event.preventDefault();
      sessionStorage.removeItem('usuario');
      this.router.navigateByUrl('/');
  }
}
