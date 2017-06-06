import { Aluno } from './aluno';
import { Disciplina } from './disciplina';

export class Presenca {
    id: number;
    data: Date;
    presente: boolean;
    aluno: Aluno = new Aluno();
    disciplina: Disciplina = new Disciplina();
}
