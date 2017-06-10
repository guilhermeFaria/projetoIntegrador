import { Component, OnInit } from '@angular/core';

import { Disciplina } from '../model/disciplina';
import { Aluno } from '../model/aluno';
import { DisciplinaService } from '../service/disciplina.service';
import { AlunoService } from '../service/aluno.service';
import { ChamadaService } from '../service/chamada.service';

@Component({
  selector: 'app-presenca',
  templateUrl: './presenca.component.html',
  styleUrls: ['./presenca.component.css']
})
export class PresencaComponent {

	disciplinas: Disciplina[];
	presencas: number[] = [];
	faltas: number[] = [];
	aluno: Aluno;

	constructor(private disciplinaService: DisciplinaService,
				private alunoService: AlunoService,
				private chamadaService: ChamadaService) {

		alunoService.buscar().subscribe(alu => {
			this.aluno = alu;
			
			disciplinaService.buscarPorAluno(this.aluno).subscribe(disc => {
				this.disciplinas = disc;

				this.disciplinas.forEach(d => {
					this.faltas.push(0);
					this.presencas.push(0);

					this.getFaltas(d);
					this.getPresencas(d);
				});
			});
		});
	}

	getFaltas(disciplina: Disciplina) {
		this.chamadaService.getFaltas(this.aluno, disciplina).subscribe(r => {
			this.faltas[this.disciplinas.indexOf(disciplina)] = r;
		});
	}

	getPresencas(disciplina: Disciplina) {
		this.chamadaService.getPresencas(this.aluno, disciplina).subscribe(r => {
			this.presencas[this.disciplinas.indexOf(disciplina)] = r;
		});
	}
}
