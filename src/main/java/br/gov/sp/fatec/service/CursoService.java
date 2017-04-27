package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Curso;

public interface CursoService {

	public Curso buscar(Long id);
	public List<Curso> buscarTodos();
	public void salvar(Curso curso);
}
