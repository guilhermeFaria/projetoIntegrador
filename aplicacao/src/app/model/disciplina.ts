import { Curso } from './curso';
import { Professor } from './professor';

export class Disciplina {
    id: number;
    nome: string;
    curso: Curso = new Curso();
    professor: Professor = new Professor();
}
