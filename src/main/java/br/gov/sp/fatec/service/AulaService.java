package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Aula;

public interface AulaService {
	public Aula buscar(Long id);
	public List<Aula> buscarTodos();
	public Aula salvar(Aula aula);

}
