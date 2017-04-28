package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Professor;

public interface ProfessorService {
	public Professor buscar(Long id);
	public List<Professor> buscarTodos();
	public Professor salvar(Professor professor);

}
