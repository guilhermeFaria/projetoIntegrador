import { Usuario } from './usuario';

export class Aluno {
    id: number;
    ra: string;
    usuario: Usuario = new Usuario();
}
