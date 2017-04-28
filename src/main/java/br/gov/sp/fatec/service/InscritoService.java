package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Inscrito;

public interface InscritoService {

	public Inscrito buscar(Long id);
	public List<Inscrito> buscarTodos();
	public Inscrito salvar(Inscrito inscrito);
}
