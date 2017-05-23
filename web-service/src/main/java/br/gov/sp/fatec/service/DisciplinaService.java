package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Disciplina;

public interface DisciplinaService {
	public Disciplina buscar(Long id);
	public List<Disciplina> buscarTodos();
	public Disciplina salvar(Disciplina disciplina);

}
