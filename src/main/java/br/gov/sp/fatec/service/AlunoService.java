package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Aluno;

public interface AlunoService {
	
	public Aluno buscar(Long id);
	public List<Aluno> buscar(String nome);
	public List<Aluno> buscarTodos();
	public void salvar(Aluno aluno);

}
