package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Presenca;

public interface PresencaService {
	public Presenca buscar(Long id);
	public List<Presenca> buscarTodos();
	public List<Aluno> buscarPorDisciplina(Long id);
	public Presenca salvar(Presenca presenca);

}
