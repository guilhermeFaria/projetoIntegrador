import { Professor } from './professor';
import { Disciplina } from './disciplina';

export class Aula {
    id: number;
    data: Date;
    professor: Professor = new Professor();
    disciplina: Disciplina = new Disciplina();
}
