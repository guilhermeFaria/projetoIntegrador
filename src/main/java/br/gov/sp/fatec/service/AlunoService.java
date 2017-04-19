package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Aluno;

public interface AlunoService {
	public Aluno cadastrarAlunos(Aluno aluno);
	public Aluno buscar(Long id);
	public List<Aluno> buscarPorNome(String nome);
	public List<Aluno> buscarTodosAlunos();

}
