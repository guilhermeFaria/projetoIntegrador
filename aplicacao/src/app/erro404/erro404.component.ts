import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-erro404',
  templateUrl: './erro404.component.html',
  styleUrls: ['./erro404.component.css']
})
export class Erro404Component implements OnInit {

  constructor(private router: Router) { 
        this.router.navigateByUrl('/404');
    }

  ngOnInit() {
  }

}
