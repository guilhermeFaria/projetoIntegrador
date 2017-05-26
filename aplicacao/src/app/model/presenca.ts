import { Aluno } from './aluno';
import { Aula } from './aula';

export class Presenca {
    id: number;
    aluno: Aluno = new Aluno();
    aula: Aula = new Aula();
}
