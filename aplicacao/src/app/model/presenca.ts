import { Aluno } from './aluno';
import { Professor } from './professor';
import { Disciplina } from './disciplina';

export class Presenca {
    id: number;
    data: Date;
    aluno: Aluno = new Aluno();
    professor: Professor = new Professor();
    disciplina: Disciplina = new Disciplina();
}
