package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Professor;

public interface ProfessorService {
	public Professor cadastrarProfessores(Professor prof);
	public Professor buscar(Long id);
	public List<Professor> buscar(String nome);
	public List<Professor> buscarTodos();

}
