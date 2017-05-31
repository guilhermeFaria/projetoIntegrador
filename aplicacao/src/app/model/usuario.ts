import { Autorizacao } from './autorizacao';

export class Usuario {
    id: number;
    nome: string;
    login: string;
    senha: string;
    status: boolean;
    autorizacoes: Autorizacao[];
}
