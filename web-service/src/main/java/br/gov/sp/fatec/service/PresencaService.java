package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Presenca;

public interface PresencaService {
	public Presenca buscar(Long id);
	public List<Presenca> buscarTodos();
	public Presenca salvar(Presenca presenca);

}
